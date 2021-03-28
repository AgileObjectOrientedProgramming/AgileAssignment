package ForYouShipment.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ForYouShipment.Models.Storage;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Workers.IDGenerator;

@Controller
@RequestMapping("/Login")
public class LoginController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {
        System.out.println("ASDASD");
        return "Login/Index";
    }

    @RequestMapping(value = "/New", method = RequestMethod.POST)
    public String Login(HttpServletRequest req, Model m, HttpSession session) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        session.setAttribute("username", username);

        System.out.println("Received user " + username + " and password " + password);
        return "redirect:/Users/Index";
    }

}
