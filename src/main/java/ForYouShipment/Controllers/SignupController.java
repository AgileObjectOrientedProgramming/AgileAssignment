package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ForYouShipment.Models.ClientProfileModel;
import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Storage.UserStorage;
import ForYouShipment.Workers.IDGenerator;
import ForYouShipment.Workers.ValidationWorker;

@Controller
@RequestMapping("/Signup")
public class SignupController extends BaseController {

    @RequestMapping(value={ "/Index", "/", "" })
    public String  ReturnSignupForm(HttpServletRequest req, Model m, HttpSession session) {
        if (!HasAccess("/Signup", session, req)) 
            return "redirect:/Login";
        
        UserModel user = new ClientUserModel();
        user.setProfile(new ClientProfileModel());

        m.addAttribute("SignUpUser", user);

        m.addAttribute("SignedUser", GetUser(session));
        return "Signup/Index";
    }

    @RequestMapping(value ={"/CreateUser"}, method = RequestMethod.POST)
    public String CreateUser(HttpServletRequest req, Model m, HttpSession session, 
                            @RequestParam("Username") String Username,
                            @RequestParam("Password") String Password,
                            @RequestParam("PasswordRetype") String PasswordRetype) {
        
        if (!HasAccess("/Signup", session, req)) 
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