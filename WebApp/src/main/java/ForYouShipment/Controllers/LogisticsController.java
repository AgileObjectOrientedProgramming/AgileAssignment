package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/Logistics")
public class LogisticsController extends BaseController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess("/Logistics", session, req))
            return "redirect:/Login/";
        
        m.addAttribute("SignedUser", GetUser(session));
        return "Logistics/Index";
    }


}
