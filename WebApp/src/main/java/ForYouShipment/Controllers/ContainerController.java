package ForYouShipment.Controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ForYouShipment.Facade.ContainerFacade;
import ForYouShipment.Models.JourneyInfo;


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
}
