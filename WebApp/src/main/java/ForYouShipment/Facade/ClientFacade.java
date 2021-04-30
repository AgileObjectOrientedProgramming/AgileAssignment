package ForYouShipment.Facade;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import ForYouShipment.ClientSearch.CriteriaUsername;
import ForYouShipment.Constants.AccessActionNounEnum;
import ForYouShipment.Constants.AccessActionVerbEnum;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Search.Criteria;
import ForYouShipment.Storage.UserStorage;
import ForYouShipment.Workers.AuthenticateUserWorker;
import ForYouShipment.Workers.ValidationWorker;

public class ClientFacade extends Facade {
    

    public static String Index(HttpServletRequest req, Model m, HttpSession session) {
        if (!HasAccess(AccessActionNounEnum.CLIENT_MANAGEMENT, AccessActionVerbEnum.INDEX, session, req))
            return "redirect:/Login/";
        
        UserModel user = GetUser(session);

        m.addAttribute("User", user);

        // Send Username to the view
        m.addAttribute("Username", user.getUsername());
        
        m.addAttribute("SignedUser", GetUser(session));
        return "Client/Index";
    }

    public static String View(HttpServletRequest req, Model m, HttpSession session, String ProfileID) {
        //ID of the signed user
        UserModel signedUser = GetUser(session);
        UserModel profileUser = AuthenticateUserWorker.GetUserByID(ProfileID);

        if (!HasAccess(AccessActionNounEnum.CLIENT_MANAGEMENT, AccessActionVerbEnum.PERSONAL, session, req))
            return "redirect:/Login/";

        if (signedUser != profileUser && !signedUser.IsLogisticUser())
            return "redirect:/Login/";


        m.addAttribute("ProfileUser", profileUser);
        
        m.addAttribute("SignedUser", GetUser(session));
        return "Client/View";
    }

    public static String Search(HttpServletRequest req, Model m, HttpSession session) {
        if (!HasAccess(AccessActionNounEnum.CLIENT_MANAGEMENT, AccessActionVerbEnum.SEARCH, session, req))
            return "redirect:/Login/";


        String Query = req.getParameter("Query");
        if (Query == null)
            Query = "";

        List<UserModel> answer = new ArrayList<>();

        Criteria<UserModel> username = new CriteriaUsername();
        answer = username.meetCriteria(new ArrayList<UserModel>(UserStorage.GetInstance().getUsers()),
        Query);

        m.addAttribute("Query", Query);
        m.addAttribute("answer", answer);
        m.addAttribute("SignedUser", GetUser(session));
        return "Client/Search";
    }

    public static String Delete(HttpServletRequest req, HttpSession session, String ID) {
        if (!HasAccess(AccessActionNounEnum.CLIENT_MANAGEMENT, AccessActionVerbEnum.DELETE, session, req))
            return "redirect:/Login/";

        UserModel user = AuthenticateUserWorker.GetUserByID(ID);

        UserStorage.GetInstance().getUsers().remove(user);
        
        return "redirect:/Logistics";
    }

    public static String Edit(HttpServletRequest req, Model m, HttpSession session) {
        if (!HasAccess(AccessActionNounEnum.CLIENT_MANAGEMENT, AccessActionVerbEnum.EDIT, session, req))
            return "redirect:/Login/";


        m.addAttribute("SignedUser", GetUser(session));
        return "Client/Edit";
    }

    public static String EditPost(HttpServletRequest req, Model m, HttpSession session, String Password,
            String PasswordRetype) {
        if (!HasAccess(AccessActionNounEnum.CLIENT_MANAGEMENT, AccessActionVerbEnum.EDIT, session, req))
            return "redirect:/Login/";

 

        UserModel user = GetUser(session);

        for (String Param : user.getProfile().getAllParameters()) {
            String value = req.getParameter(Param);
            user.getProfile().setParameter(Param, value);
        }


        String PasswordCheckResult = ValidationWorker.PasswordIsValid(Password, PasswordRetype);
        if (PasswordCheckResult != null && Password != "") {
            m.addAttribute("warning", PasswordCheckResult);
            m.addAttribute("SignedUser", GetUser(session));
            return "Client/Edit";
        }

        if (Password != "") {
            user.setPassword(Password);
        }
        
        return "redirect:/Client/View?ID=" + user.getID();
    }
}
