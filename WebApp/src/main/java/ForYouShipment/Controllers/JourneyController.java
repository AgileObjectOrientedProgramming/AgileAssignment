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
import ForYouShipment.Models.Journey;
import ForYouShipment.Models.JourneyInfo;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Storage.JourneyStorage;
import ForYouShipment.Workers.ContainerRegister;



@Controller
@RequestMapping("/Journey")
public class JourneyController extends BaseController {
    
    @RequestMapping(value={ "/Index", "/" , ""})
    public String Index(HttpServletRequest req, Model m, HttpSession session) {

        if (!HasAccess(AccessActionNounEnum.JOURNEY_PAGE, AccessActionVerbEnum.INDEX, session, req))
            return "redirect:/Login/";
        
        List<Journey> journey_list = new ArrayList<>(); 
        
        UserModel user = GetUser(session);
        for (Journey j : JourneyStorage.GetInstance().getJourneys()) {
            System.out.println(j.getInfo().getParameter("Username"));
            if (j.getInfo().getParameter("Username").equals(user.getUsername())) {
                journey_list.add(j);
            }
        }
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
        JourneyInfo info = new JourneyInfo();
        info.setParameter("Username", user.getUsername());
        info.setParameter("ID", user.getID());
        
        ContainerRegister.setJourney(origin, destination, content_type, company,(ContainerRegister.getFreeContainer(Port.valueOf(origin))), info);

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

        List<Journey> answer = new ArrayList<>();

        UserModel user = GetUser(session);
        for (Journey j : JourneyStorage.GetInstance().getJourneys()) {
            if (user.IsLogisticUser()) {
                if (j.getOrigin().toString().contains(Query)) {
                    answer.add(j);
                }
            }
            else if ((j.getInfo().getParameter("Username").equals(user.getUsername()))) {
                if (j.getOrigin().toString().contains(Query)) {
                    answer.add(j);
                }
            }
        }


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
        
    // @RequestMapping(value={ "/Search" })
    // public String Search(HttpServletRequest req, Model m, HttpSession session) {

    //     if (!HasAccess(AccessActionNounEnum.JOURNEY_PAGE, AccessActionVerbEnum.SEARCH, session, req))
    //         return "redirect:/Login/";

    //     if (!GetUser(session).IsLogisticUser())
    //         return "redirect:/Login/";

    //     // String Query = req.getParameter("Query");
    //     // if (Query == null)
    //     //     Query = "";

    //     List<Journey> answer = new ArrayList<>();

    //     for (Journey u : JourneyStorage.GetInstance().getJourneys()) {
    //         if (u.getInfo().getParameter("Username").equals(req.getParameter("Username"))) {
    //             answer.add(u);
    //         }
    //     }

    //     m.addAttribute("Query", Query);
    //     m.addAttribute("answer", answer);
    //     m.addAttribute("SignedUser", GetUser(session));
    //     return "Client/Search";
    // }
}
