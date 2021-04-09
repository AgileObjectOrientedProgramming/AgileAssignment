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
import ForYouShipment.Workers.ContainerTracker;


@Controller
@RequestMapping("/Container")
public class ContainerController extends BaseController {
	
    @RequestMapping(value={ "/New", "/New/" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess(AccessActionNounEnum.CONTAINER_PAGE, AccessActionVerbEnum.CREATE, session, req))
            return "redirect:/Login/"; // why?
        
        m.addAttribute("SignedUser", GetUser(session));
        
        return "Container/New";
    }
    
    @RequestMapping(value = {"/New", "/New/"}, method = RequestMethod.POST)
    public String trackContainer(HttpServletRequest req, Model m, HttpSession session,
                        @RequestParam("temperature") String temperature, 
                        @RequestParam("humidity") String humidity,
                        @RequestParam("pressure") String pressure) {
        
        
    	ContainerTracker.setMeasurements(temperature, humidity, pressure, 
    			ContainerTracker.getContainer()); 

    	m.addAttribute("SignedUser", GetUser(session));
    	
        return "redirect:/Login/";                            
    }

}
