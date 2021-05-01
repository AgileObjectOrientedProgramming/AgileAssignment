package ForYouShipment.RefactoredControllers;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import ForYouShipment.Models.UserModel;
import ForYouShipment.Workers.AuthenticateUserWorker;

public class LoginFacade extends Facade {
    
    public static String Login(Model m, HttpSession session, String Username, String Password) {
        String ID = AuthenticateUserWorker.Authenticate(Username, Password);
    
        if (ID == null) {
            m.addAttribute("warning", "Invalid Username or Password!");
            m.addAttribute("SignedUser", GetUser(session));
            return "Login/Index";
        }

        session.setAttribute("SignedUser", ID);

        UserModel SignedUser = GetUser(session);

        if (SignedUser.IsLogisticUser())
            return "redirect:/Logistics";

        return "redirect:/Client";
    }


    
}
