package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ForYouShipment.Models.UserModel;
import ForYouShipment.Workers.AuthenticateUserWorker;


@Controller
@RequestMapping("/Client")
public class ClientController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {
        if (session.getAttribute("SignedUser") == null)
            return "redirect:/Login/";
        
        String ID = (String) session.getAttribute("SignedUser");

        UserModel user = AuthenticateUserWorker.GetUserByID(ID);

        // Checking if the user has access
        if (!user.HasAccessTo("/Client/Index"))
            return "redirect:/Login"; 
        
        m.addAttribute("Profile", user.getProfile());

        // Send Username to the view
        m.addAttribute("Username", user.getUsername());
        
        return "Client/Index";
    }

}
