package ForYouShipment.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ForYouShipment.Models.Storage;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Workers.AuthenticateClientWorker;
import ForYouShipment.Workers.ClientModelWorker;
import ForYouShipment.Workers.IDGenerator;

@Controller
@RequestMapping("/Login")
public class LoginController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {
        return "Login/Index";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String Login(HttpServletRequest req, Model m, HttpSession session,
                @RequestParam("Username") String Username, 
                @RequestParam("Password") String Password) {

        // String ID = ClientModelWorker.GetInstance().Authenticate(Username, Password);
        String ID = AuthenticateClientWorker.Authenticate(Username, Password);
    
        if (ID == null) {
            m.addAttribute("warning", "Invalid Username or Password!");
            return "Login/Index";
        }

        session.setAttribute("SignedUser", ID);

        return "redirect:/Client";
    }

    @RequestMapping(value={ "/Logout"})
    public String Logout(HttpServletRequest req, Model m, HttpSession session) {
        session.setAttribute("SignedUser", null);
        return "redirect:/";
    }

}
