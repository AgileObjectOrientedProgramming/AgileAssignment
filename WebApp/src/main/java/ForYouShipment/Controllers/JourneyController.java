package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ForYouShipment.Constants.AccessActionNounEnum;
import ForYouShipment.Constants.AccessActionVerbEnum;
import ForYouShipment.Constants.Port;
import ForYouShipment.Workers.ContainerRegister;



@Controller
@RequestMapping("/Journey")
public class JourneyController extends BaseController {
    
    @RequestMapping(value={ "/New", "/New/" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess(AccessActionNounEnum.JOURNEY_PAGE, AccessActionVerbEnum.CREATE, session, req))
            return "redirect:/Login/";
        
       
        return "Journey/New";
    }

    @RequestMapping(value = {"/New", "/New/"}, method = RequestMethod.POST)
    public String registerContainer(HttpServletRequest req, Model m, HttpSession session,
                        @RequestParam("Origin") String origin, 
                        @RequestParam("Destination") String destination,
                        @RequestParam("Content type") String content_type,
                        @RequestParam("Company") String company) {
        
        
        ContainerRegister.setJourney(origin, destination, content_type, company,
                                         ContainerRegister.getFreeContainer(Port.valueOf(origin)));

        
                            
        return "redirect:/Login/";                            
    }
        

}
