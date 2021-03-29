package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

<<<<<<< HEAD
import ForYouShipment.Workers.AuthenticateUserWorker;

=======
import ForYouShipment.Workers.Login;
>>>>>>> 9ea1561... testing

@Controller
@RequestMapping("/Login")
public class LoginController {
    
    /**
     * This function sends the user to the authentification form where he/she can log in as a client or as a logistics user.
     */
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {
        return "Login/Index";
    }

    /**
     * This function receives back the authentification form and if the user is valid then authenticates.
     * Authentification is made by added this "SignedUser" parameter with value ID to the session.
     */
    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String Login(HttpServletRequest req, Model m, HttpSession session,
                @RequestParam("Username") String Username, 
                @RequestParam("Password") String Password) {

<<<<<<< HEAD
        String ID = AuthenticateUserWorker.Authenticate(Username, Password);
=======
        // String ID = ClientModelWorker.GetInstance().Authenticate(Username, Password);
        String ID = Login.Authenticate(Username, Password);
>>>>>>> 9ea1561... testing
    
        if (ID == null) {
            m.addAttribute("warning", "Invalid Username or Password!");
            return "Login/Index";
        }

        session.setAttribute("SignedUser", ID);

        return "redirect:/Client";
    }

    /**
     * This function is used in order to log our any type of user.
     */
    @RequestMapping(value={ "/Logout"})
    public String Logout(HttpServletRequest req, Model m, HttpSession session) {
        session.setAttribute("SignedUser", null);
        return "redirect:/";
    }

}
