package ForYouShipment.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
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
import ForYouShipment.Constants.Port;
import ForYouShipment.Models.JourneyInfo;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Search.Criteria;
import ForYouShipment.Search.CriteriaCompany;
import ForYouShipment.Search.CriteriaContent_Type;
import ForYouShipment.Search.CriteriaDestination;
import ForYouShipment.Search.CriteriaOrigin;
import ForYouShipment.Search.CriteriaUser;
import ForYouShipment.Search.OrCriteria;
import ForYouShipment.Storage.JourneyStorage;
import ForYouShipment.Workers.ContainerRegister;



@Controller
@RequestMapping("/Journey")
public class JourneyController extends BaseController {
    
    @RequestMapping(value={ "/Index", "/" , ""})
    public String Index(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess(AccessActionNounEnum.JOURNEY_PAGE, AccessActionVerbEnum.INDEX, session, req))
            return "redirect:/Login/";
        
        List<JourneyInfo> journey_list = new ArrayList<>(); 
        
        UserModel user = GetUser(session);
        Criteria<JourneyInfo> user_journeys = new CriteriaUser();
        journey_list = user_journeys.meetCriteria(new ArrayList<JourneyInfo>(JourneyStorage.GetInstance().getJourneys()),
                                                    user.getUsername());


        m.addAttribute("Ownjourneys", journey_list);
        m.addAttribute("SignedUser", GetUser(session));
        return "Journey/Index";
    }


    @RequestMapping(value={ "/New", "/New/" })
    public String New(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess(AccessActionNounEnum.JOURNEY_PAGE, AccessActionVerbEnum.CREATE, session, req))
            return "redirect:/Login/";
        
        m.addAttribute("Port list", new ArrayList<Port>(Arrays.asList(Port.values())));
        m.addAttribute("SignedUser", GetUser(session));
        return "Journey/New";
    }

    @RequestMapping(value = {"/New", "/New/"}, method = RequestMethod.POST)
    public String registerContainer(HttpServletRequest req, Model m, HttpSession session,
                        @RequestParam("Origin") String origin, 
                        @RequestParam("Destination") String destination,
                        @RequestParam("Content type") String content_type,
                        @RequestParam("Company") String company) {
        
        
        UserModel user = GetUser(session);

        ContainerRegister.setJourney(origin, destination, content_type, company, user );

        m.addAttribute("SignedUser", GetUser(session));                    
        return "redirect:/Journey/Index";                            
    }

    @RequestMapping(value={ "/Search" })
    public String Search(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess(AccessActionNounEnum.JOURNEY_PAGE, AccessActionVerbEnum.SEARCH, session, req))
            return "redirect:/Login/";


        String Query = req.getParameter("Query");
        if (Query == null)
            Query = "";

        List<JourneyInfo> answer = new ArrayList<>();
        
        Criteria<JourneyInfo> origin = new CriteriaOrigin();
        Criteria<JourneyInfo> destination = new CriteriaDestination();
        Criteria<JourneyInfo> content = new CriteriaContent_Type();
        Criteria<JourneyInfo> company = new CriteriaCompany();
        Criteria<JourneyInfo> originOrDestination = new OrCriteria<JourneyInfo>(origin, destination);
        Criteria<JourneyInfo> contentOrCompany = new OrCriteria<JourneyInfo>(content, company);
        Criteria<JourneyInfo> allCriteria = new OrCriteria<JourneyInfo>(originOrDestination, contentOrCompany);
        if (GetUser(session).IsLogisticUser()) {
            Criteria<JourneyInfo> user = new CriteriaUser();
            allCriteria = new OrCriteria<JourneyInfo>(allCriteria, user);
        }
        /* We are matching our query with all the fields set up by the user for a Journey*/
        answer = allCriteria.meetCriteria(new ArrayList<JourneyInfo>(JourneyStorage.GetInstance().getJourneys()),
                                                    Query);

        


        m.addAttribute("Query", Query);
        m.addAttribute("answer", answer);
        m.addAttribute("SignedUser", GetUser(session));
        return "Journey/Search";
    }

    // @RequestMapping(value={ "/View" })
    // public String View(HttpServletRequest req, Model m, HttpSession session,
    //                 @RequestParam("ID") String ProfileID) {

    //     //ID of the signed user
    //     UserModel signedUser = GetUser(session);
    //     UserModel profileUser = AuthenticateUserWorker.GetUserByID(ProfileID);

    //     if (!HasAccess(AccessActionNounEnum.CLIENT_MANAGEMENT, AccessActionVerbEnum.PERSONAL, session, req))
    //         return "redirect:/Login/";

    //     if (signedUser != profileUser && !signedUser.IsLogisticUser())
    //         return "redirect:/Login/";


    //     m.addAttribute("ProfileUser", profileUser);
        
    //     m.addAttribute("SignedUser", GetUser(session));
    //     return "Client/View";
    // }
        
  
}
