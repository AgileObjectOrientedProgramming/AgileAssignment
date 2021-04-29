package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ForYouShipment.Facade.JourneyFacade;




@Controller
@RequestMapping("/Journey")
public class JourneyController extends BaseController {
    
    @RequestMapping(value={ "/Index", "/" , ""})
    public String Index(HttpServletRequest req, Model m, HttpSession session) {

        return JourneyFacade.Index(req, m, session);
    }


    @RequestMapping(value={ "/New", "/New/" })
    public String New(HttpServletRequest req, Model m, HttpSession session) {

        return JourneyFacade.New(req, m, session);
    }


    @RequestMapping(value = {"/New", "/New/"}, method = RequestMethod.POST)
    public String registerContainer(HttpServletRequest req, Model m, HttpSession session,
                        @RequestParam("Origin") String origin, 
                        @RequestParam("Destination") String destination,
                        @RequestParam("Content type") String content_type,
                        @RequestParam("Company") String company) throws Exception {
        
        return JourneyFacade.registerContainer(m, session, origin, destination, content_type, company);                            
    }


    @RequestMapping(value={ "/Search" })
    public String Search(HttpServletRequest req, Model m, HttpSession session) {

        return JourneyFacade.Search(req, m, session);
    }

    @RequestMapping(value={ "/View" })
    public String View(HttpServletRequest req, Model m, HttpSession session,
                    @RequestParam("ID") String JourneyId) {
        

        return JourneyFacade.View(m, session, JourneyId);
    }


    @RequestMapping(value = {"/Measurements", "/Measurements/"})
    public String SetMeasurement(HttpServletRequest req, Model m, HttpSession session,
                                 @RequestParam("ID") String ID) {

        return JourneyFacade.SetMeasurement(req, m, session, ID);

    }

    
    @RequestMapping(value = {"/Measurements", "/Measurements/"}, method = RequestMethod.POST)
    public String SetMeasurement2(HttpServletRequest req, Model m, HttpSession session) {
    
        return JourneyFacade.SetMeasurement2(req, m, session);                         
    }
}
