package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ForYouShipment.Constants.AccessActionNounEnum;
import ForYouShipment.Constants.AccessActionVerbEnum;
import ForYouShipment.Storage.JourneyStorage;
import ForYouShipment.Storage.UserStorage;



@Controller
@RequestMapping("/Logistics")
public class LogisticsController extends BaseController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess(AccessActionNounEnum.LOGISTICS_MANAGEMENT, AccessActionVerbEnum.INDEX, session, req))
            return "redirect:/Login/";

        int numberClients = UserStorage.GetInstance().countClients();
        m.addAttribute("numberClients", numberClients);

        int numberAprovedJourneys = JourneyStorage.GetInstance().countJourneysApproved();
        m.addAttribute("numberAprovedJourneys", numberAprovedJourneys);

        int numberJourneysToApprove = JourneyStorage.GetInstance().countJourneysToApprove();
        m.addAttribute("numberJourneysToApprove", numberJourneysToApprove);
        
        m.addAttribute("SignedUser", GetUser(session));
        return "Logistics/Index";
    }


}
