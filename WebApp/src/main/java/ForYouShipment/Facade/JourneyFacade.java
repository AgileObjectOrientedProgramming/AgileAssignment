package ForYouShipment.Facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import ForYouShipment.Constants.AccessActionNounEnum;
import ForYouShipment.Constants.AccessActionVerbEnum;
import ForYouShipment.Constants.Port;
import ForYouShipment.Models.ContainerMeasurements;
import ForYouShipment.Models.JourneyInfo;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Search.Criteria;
import ForYouShipment.Search.CriteriaCID;
import ForYouShipment.Search.CriteriaCJID;
import ForYouShipment.Search.CriteriaCompany;
import ForYouShipment.Search.CriteriaContent_Type;
import ForYouShipment.Search.CriteriaDestination;
import ForYouShipment.Search.CriteriaJID;
import ForYouShipment.Search.CriteriaOrigin;
import ForYouShipment.Search.CriteriaUser;
import ForYouShipment.Search.OrCriteria;
import ForYouShipment.Storage.ContainerStorage;
import ForYouShipment.Storage.JourneyStorage;
import ForYouShipment.Workers.ContainerRegister;

public class JourneyFacade extends Facade{
    

    public static String Index(HttpServletRequest req, Model m, HttpSession session) {
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

    

    public static String New(HttpServletRequest req, Model m, HttpSession session) {
        if (!HasAccess(AccessActionNounEnum.JOURNEY_PAGE, AccessActionVerbEnum.CREATE, session, req))
            return "redirect:/Login/";
        
  

        m.addAttribute("Ports", Port.class.getEnumConstants());
        m.addAttribute("SignedUser", GetUser(session));
        return "Journey/New";
    }

    public static String registerContainer(Model m, HttpSession session, String origin, String destination, String content_type,
            String company) throws Exception {
        try {
            Port.ofString(origin);
            Port.ofString(destination);
            
        } catch (Exception e) {
            m.addAttribute("warning", "Invalid origin or destination");
            m.addAttribute("SignedUser", GetUser(session));    
            return "Journey/New";
        }
        UserModel user = GetUser(session);

        ContainerRegister.setJourney(origin, destination, content_type, company, user );
        m.addAttribute("Ports", Port.class.getEnumConstants());
        m.addAttribute("SignedUser", GetUser(session));                    
        return "redirect:/Journey/Index";
    }

    public static String Search(HttpServletRequest req, Model m, HttpSession session) {
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
            answer = allCriteria.meetCriteria(new ArrayList<JourneyInfo>(JourneyStorage.GetInstance().getJourneys()),
                                                    Query);
        }
        else { 
            List<JourneyInfo> journey_list = new ArrayList<>(); 
        
            UserModel user = GetUser(session);
            Criteria<JourneyInfo> user_journeys = new CriteriaUser();
            journey_list = user_journeys.meetCriteria(new ArrayList<JourneyInfo>(JourneyStorage.GetInstance().getJourneys()),
                                                        user.getUsername());

            answer = allCriteria.meetCriteria(journey_list, Query);

        }
        /* We are matching our query with all the fields set up by the user for a Journey*/
        

        m.addAttribute("Query", Query);
        m.addAttribute("answer", answer);
        m.addAttribute("SignedUser", GetUser(session));
        return "Journey/Search";
    }

    public static String View(Model m, HttpSession session, String JourneyId) {
        Criteria<JourneyInfo> criteria = new CriteriaJID();
        Criteria<ContainerMeasurements> container = new CriteriaCJID();
        JourneyInfo j = criteria.meetCriteria(new ArrayList<JourneyInfo>(JourneyStorage.GetInstance().getJourneys()), JourneyId).get(0);
        ContainerMeasurements c = container.meetCriteria(new ArrayList<ContainerMeasurements>(ContainerStorage.GetInstance().getContainers()), JourneyId).get(0);
        m.addAttribute("ContainerID", c.getId());
        m.addAttribute("Journey", j); 
        m.addAttribute("ID", JourneyId);
        m.addAttribute("Latitude", Double.parseDouble(c.getParameter("Latitude")));
        m.addAttribute("Longitude", Double.parseDouble(c.getParameter("Longitude")));
        m.addAttribute("SignedUser", GetUser(session)); 
        m.addAttribute("ports", Port.class.getEnumConstants());               
        return "Journey/View";
    }

    
    public static String SetMeasurement(HttpServletRequest req, Model m, HttpSession session, String ID) {
        if (!HasAccess(AccessActionNounEnum.CONTAINER_PAGE, AccessActionVerbEnum.CREATE, session, req))
            return "redirect:/Login/";
        
        
        Criteria<ContainerMeasurements> container = new CriteriaCID();
        ContainerMeasurements c = container.meetCriteria(new ArrayList<ContainerMeasurements>(ContainerStorage.GetInstance().getContainers()), ID).get(0);
        m.addAttribute("SignedUser", GetUser(session));
        m.addAttribute("Container", c);
        m.addAttribute("ContainerID", ID);
        return "Journey/Measurements" ;
    }

    public static String SetMeasurement2(HttpServletRequest req, Model m, HttpSession session) {
        String ID = req.getParameter("ContainerID");                   
        Criteria<ContainerMeasurements> container = new CriteriaCID();
        ContainerMeasurements c = container.meetCriteria(new ArrayList<ContainerMeasurements>(ContainerStorage.GetInstance().getContainers()), ID).get(0);
        
        for (String Param : c.getAllParameters()) {
            String value = req.getParameter(Param);
            c.setParameter(Param, value);
        }

        Map<String, String> measurements = c.getParameters();
        c.saveMeasurements(measurements);
    	m.addAttribute("SignedUser", GetUser(session));
    	
        return "redirect:/Journey/Search/";
    }
}
