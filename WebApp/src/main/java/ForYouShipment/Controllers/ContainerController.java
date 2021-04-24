package ForYouShipment.Controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ForYouShipment.Constants.AccessActionNounEnum;
import ForYouShipment.Constants.AccessActionVerbEnum;
import ForYouShipment.Models.JourneyInfo;
import ForYouShipment.Workers.ContainerTracker;


@Controller
@RequestMapping("/Container")
public class ContainerController extends BaseController {
    

	
    @RequestMapping(value={ "/Measurements", "/Measurements/" })
    public String New(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess(AccessActionNounEnum.CONTAINER_PAGE, AccessActionVerbEnum.CREATE, session, req))
            return "redirect:/Login/"; 
        
        

        m.addAttribute("SignedUser", GetUser(session));
        m.addAttribute("Measurements", new HashMap<String, String>());

        return "Container/Measurements";
    }
    
    @RequestMapping(value = {"/Measurements", "/Measurements/"}, method = RequestMethod.POST)
    public String trackContainer(HttpServletRequest req, Model m, HttpSession session,
                        @RequestParam("Measurements") Map<String,String> measurements, 
                        @RequestParam("Journey") JourneyInfo journey){
        
        
    	ContainerTracker.setMeasurements(measurements,journey); 

    	m.addAttribute("SignedUser", GetUser(session));
    	
        return "redirect:/Journey/View?ID=$" + journey.getId();                            
    }

}
