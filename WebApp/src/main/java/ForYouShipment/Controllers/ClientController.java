package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ForYouShipment.Models.ClientModel;
import ForYouShipment.Workers.Login;

@Controller
@RequestMapping("/Client")
public class ClientController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {
        if (session.getAttribute("SignedUser") == null)
            return "redirect:/Login/";
        
        String ID = (String) session.getAttribute("SignedUser");

        ClientModel client = Login.GetClientByID(ID);

        m.addAttribute("client", client);
        
        return "Client/Index";
    }

}
