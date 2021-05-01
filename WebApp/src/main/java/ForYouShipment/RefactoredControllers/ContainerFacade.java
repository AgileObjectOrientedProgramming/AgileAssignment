package ForYouShipment.RefactoredControllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import ForYouShipment.Constants.AccessActionNounEnum;
import ForYouShipment.Constants.AccessActionVerbEnum;
import ForYouShipment.Models.JourneyInfo;
import ForYouShipment.Workers.ContainerTracker;

public class ContainerFacade extends Facade{
    
    public static String New(HttpServletRequest req, Model m, HttpSession session) {
        if (!HasAccess(AccessActionNounEnum.CONTAINER_PAGE, AccessActionVerbEnum.CREATE, session, req))
            return "redirect:/Login/"; 
        
        

        m.addAttribute("SignedUser", GetUser(session));
        m.addAttribute("Measurements", new HashMap<String, String>());

        return "Container/Measurements";
    }

    public static String doMeasurements(Model m, HttpSession session, Map<String, String> measurements, JourneyInfo journey) {
        ContainerTracker.setMeasurements(measurements,journey); 

    	m.addAttribute("SignedUser", GetUser(session));
    	
        return "redirect:/Journey/View?ID=$" + journey.getId();
    }
}
