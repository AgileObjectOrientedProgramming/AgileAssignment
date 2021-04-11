package ForYouShipment.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ForYouShipment.Constants.AccessActionNounEnum;
import ForYouShipment.Constants.AccessActionVerbEnum;
import ForYouShipment.Models.Journey;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Search.Criteria;
import ForYouShipment.Search.CriteriaUser;
import ForYouShipment.Storage.JourneyStorage;
import ForYouShipment.Workers.ContainerTracker;


@Controller
@RequestMapping("/Container")
public class ContainerController extends BaseController {
	
    @RequestMapping(value={ "/Index", "/" , ""})
    public String Index(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess(AccessActionNounEnum.CONTAINER_PAGE, AccessActionVerbEnum.INDEX, session, req))
            return "redirect:/Login/";
        
        List<Journey> measurement_list = new ArrayList<>(); 
        
        UserModel user = GetUser(session);
        Criteria<UserModel> user_measurements = new CriteriaUser();
        measurement_list = user_measurements.meetCriteria(new ArrayList<Journey>(JourneyStorage.GetInstance().getJourneys()),
                user.getUsername());


        m.addAttribute("Owncontainers", measurement_list);
        m.addAttribute("SignedUser", GetUser(session));
        return "Container/Index";
    }
	
    @RequestMapping(value={ "/New", "/New/" })
    public String New(HttpServletRequest req, Model m, HttpSession session) {

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
    			ContainerTracker.getJourney()); 

    	m.addAttribute("SignedUser", GetUser(session));
    	
        return "redirect:/Login/";                            
    }

}
