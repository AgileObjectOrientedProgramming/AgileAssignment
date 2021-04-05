package ForYouShipment.Controllers;

import java.util.ArrayList;
import java.util.List;

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
import ForYouShipment.Workers.AuthenticateUserWorker;
import ForYouShipment.Workers.ValidationWorker;


@Controller
@RequestMapping("/Client")
public class ClientController extends BaseController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess("/Client", session, req))
            return "redirect:/Login/";
        
        UserModel user = GetUser(session);

        m.addAttribute("User", user);

        // Send Username to the view
        m.addAttribute("Username", user.getUsername());
        
        m.addAttribute("SignedUser", GetUser(session));
        return "Client/Index";
    }

    // Should always have the ID param /Client/View?ID=1.2.3.4.
    @RequestMapping(value={ "/View" })
    public String View(HttpServletRequest req, Model m, HttpSession session,
                    @RequestParam("ID") String ProfileID) {

        if (!HasAccess("/Client/View", session, req))
            return "redirect:/Login/";

        //ID of the signed user
        UserModel signedUser = GetUser(session);
        UserModel profileUser = AuthenticateUserWorker.GetUserByID(ProfileID);

        if (signedUser != profileUser && !signedUser.IsLogisticUser())
            return "redirect:/Login/";


        m.addAttribute("ProfileUser", profileUser);
        
        m.addAttribute("SignedUser", GetUser(session));
        return "Client/View";
    }

    @RequestMapping(value={ "/Search" })
    public String Search(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess("/Client/Search", session, req))
            return "redirect:/Login/";

        if (!GetUser(session).IsLogisticUser())
            return "redirect:/Login/";

        String Query = req.getParameter("Query");
        if (Query == null)
            Query = "";

        List<UserModel> answer = new ArrayList<>();

        for (UserModel u : UserStorage.GetInstance().getUsers()) {
            if (u.getUsername().contains(Query) && !u.IsLogisticUser()) {
                answer.add(u);
            }
        }

        m.addAttribute("Query", Query);
        m.addAttribute("answer", answer);
        m.addAttribute("SignedUser", GetUser(session));
        return "Client/Search";
    }

    @RequestMapping(value={ "/Delete" })
    public String Delete(HttpServletRequest req, Model m, HttpSession session,
                        @RequestParam("ID") String ID) {

        if (!HasAccess("/Client/Delete", session, req))
            return "redirect:/Login/";

        UserModel user = AuthenticateUserWorker.GetUserByID(ID);

        UserStorage.GetInstance().getUsers().remove(user);
        return "redirect:/Logistics";
    }

    @RequestMapping(value={ "/Edit" }) 
    public String Edit(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess("/Client/Edit", session, req))
            return "redirect:/Login/";

        if (GetUser(session).IsLogisticUser())
            return "redirect:/Login/";

        m.addAttribute("SignedUser", GetUser(session));
        return "Client/Edit";
    }

    @RequestMapping(value={ "/Edit" }, method = RequestMethod.POST) 
    public String Edit(HttpServletRequest req, Model m, HttpSession session,
                @RequestParam("Password") String Password,
                @RequestParam("PasswordRetype") String PasswordRetype) {

        if (!HasAccess("/Client/Edit", session, req))
            return "redirect:/Login/";

        if (GetUser(session).IsLogisticUser())
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
