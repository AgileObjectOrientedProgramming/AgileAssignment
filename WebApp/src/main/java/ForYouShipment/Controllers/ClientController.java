package ForYouShipment.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ForYouShipment.Models.ClientModel;
import ForYouShipment.Models.Storage;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Workers.ClientModelWorker;
import ForYouShipment.Workers.IDGenerator;

@Controller
@RequestMapping("/Client")
public class ClientController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {
        if (session.getAttribute("SignedUser") == null)
            return "redirect:/Login/";
        
        String ID = (String) session.getAttribute("SignedUser");

        ClientModel client = ClientModelWorker.GetInstance().GetClientByID(ID);

        m.addAttribute("client", client);
        
        return "Client/Index";
    }

}
