package ForYouShipment.RefactoredControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import ForYouShipment.Constants.AccessActionNounEnum;
import ForYouShipment.Constants.AccessActionVerbEnum;
import ForYouShipment.Models.ClientProfileModel;
import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Persistance.StoragePersistance;
import ForYouShipment.Storage.UserStorage;
import ForYouShipment.Workers.IDGenerator;
import ForYouShipment.Workers.ValidationWorker;

public class SignupFacade extends Facade{


    public static String ReturnSignupForm(HttpServletRequest req, Model m, HttpSession session) {
        if (!HasAccess(AccessActionNounEnum.SIGNUP_PAGE, AccessActionVerbEnum.INDEX, session, req)) 
            return "redirect:/Login";
        
        UserModel user = new ClientUserModel();
        user.setProfile(new ClientProfileModel());

        m.addAttribute("SignUpUser", user);

        m.addAttribute("SignedUser", GetUser(session));
        return "Signup/Index";
    }

    public static String createUser(HttpServletRequest req, Model m, HttpSession session, String Username, String Password,
            String PasswordRetype) {
        if (!HasAccess(AccessActionNounEnum.SIGNUP_PAGE, AccessActionVerbEnum.CREATE, session, req)) 
            return "redirect:/Login";

        UserModel user = new ClientUserModel();
        user.setProfile(new ClientProfileModel());

        user.setUsername(Username);
        user.setPassword(Password);
        user.setProfile(new ClientProfileModel());

        for (String Param : user.getProfile().getAllParameters()) {
            String value = req.getParameter(Param);
            user.getProfile().setParameter(Param, value);
        }

        m.addAttribute("SignUpUser", user);

        String UsernameCheckResult = ValidationWorker.UsernameIsValid(Username);
        if (UsernameCheckResult != null) {
            m.addAttribute("warning", UsernameCheckResult);
            m.addAttribute("SignedUser", GetUser(session));
            return "Signup/Index";
        }
        String PasswordCheckResult = ValidationWorker.PasswordIsValid(Password, PasswordRetype);
        if (PasswordCheckResult != null) {
            m.addAttribute("warning", PasswordCheckResult);
            m.addAttribute("SignedUser", GetUser(session));
            return "Signup/Index";
        }

        String ID = IDGenerator.GenerateID();

        user.setID(ID);
        
        UserStorage.GetInstance().getUsers().add(user);

        return "redirect:/Logistics";
    }
    
}
