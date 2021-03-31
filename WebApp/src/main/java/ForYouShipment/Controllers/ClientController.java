package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
<<<<<<< HEAD
import ForYouShipment.Models.UserModel;
import ForYouShipment.Workers.AuthenticateUserWorker;

=======
import ForYouShipment.Models.ClientModel;
import ForYouShipment.Workers.Login;
>>>>>>> 9ea1561... testing
=======
import ForYouShipment.Models.ClientModel;
import ForYouShipment.Workers.Login;
>>>>>>> 9ea15615b9cf880c7adab899e9a7ddb0a52a457b

@Controller
@RequestMapping("/Client")
public class ClientController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {
        if (session.getAttribute("SignedUser") == null)
            return "redirect:/Login/";
        
        String ID = (String) session.getAttribute("SignedUser");

<<<<<<< HEAD
<<<<<<< HEAD
        UserModel user = AuthenticateUserWorker.GetUserByID(ID);

        // Checking if the user has access
        if (!user.HasAccessTo("/Client/Index"))
            return "redirect:/Login"; 
        
        m.addAttribute("Profile", user.getProfile());
=======
        ClientModel client = Login.GetClientByID(ID);
>>>>>>> 9ea1561... testing
=======
        ClientModel client = Login.GetClientByID(ID);
>>>>>>> 9ea15615b9cf880c7adab899e9a7ddb0a52a457b

        // Send Username to the view
        m.addAttribute("Username", user.getUsername());
        
        return "Client/Index";
    }

}
