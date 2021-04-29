package ForYouShipment.Controllers;

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
import ForYouShipment.Facade.ContainerFacade;
import ForYouShipment.Models.ContainerMeasurements;
import ForYouShipment.Models.JourneyInfo;
import ForYouShipment.Workers.ContainerRegister;
import ForYouShipment.Workers.LoggingWorker;


@Controller
@RequestMapping("/Container")
public class ContainerController extends BaseController {
    
    @RequestMapping(value={ "/Measurements", "/Measurements/" })
    public String New(HttpServletRequest req, Model m, HttpSession session) {

        return ContainerFacade.New(req, m, session);
    }
        
    @RequestMapping(value = {"/Measurements", "/Measurements/"}, method = RequestMethod.POST)
    public String doMeasurements(HttpServletRequest req, Model m, HttpSession session,
                        @RequestParam("Measurements") Map<String,String> measurements, 
                        @RequestParam("Journey") JourneyInfo journey){
        
    	return ContainerFacade.doMeasurements(m, session, measurements, journey);                            
    }
    
    @RequestMapping(value = {"/Delete" }, method = RequestMethod.POST)
    public String DeleteContainer(HttpServletRequest req, Model m, HttpSession session,
                        @RequestParam("ID") String ID){
        if (!HasAccess(AccessActionNounEnum.CONTAINER_MANAGEMENT, AccessActionVerbEnum.GENERAL, session, req))
            return "redirect:/Login/";
        
        ContainerRegister.DeleteContainer(ID);
        return "redirect:/Logistics";
    }
    


    @RequestMapping(value={ "/View" }) 
    public String ViewContainer(HttpServletRequest req, Model m, HttpSession session,
                @RequestParam("ID") String ID) throws Exception{
        if (!HasAccess(AccessActionNounEnum.CONTAINER_MANAGEMENT, AccessActionVerbEnum.GENERAL, session, req))
            return "redirect:/Login/";
        
        try {
            ContainerMeasurements c = ContainerRegister.GetContainerByID(ID);
            if (c == null)
                throw new Exception("c is null");

            m.addAttribute("Container", c);
            m.addAttribute("SignedUser", GetUser(session));
            return "Container/View";
        }
        catch (Exception e) {
            LoggingWorker.GetInstance().Log(e.getMessage());
            return "redirect:/error/view";
        }
    }
}
