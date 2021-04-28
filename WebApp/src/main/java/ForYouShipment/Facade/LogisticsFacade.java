package ForYouShipment.Facade;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import ForYouShipment.Constants.AccessActionNounEnum;
import ForYouShipment.Constants.AccessActionVerbEnum;
import ForYouShipment.Constants.Port;
import ForYouShipment.Storage.ContainerStorage;
import ForYouShipment.Storage.JourneyStorage;
import ForYouShipment.Storage.UserStorage;

public class LogisticsFacade extends Facade{
    
    
    public static String Index(HttpServletRequest req, Model m, HttpSession session) throws Exception {
        if (!HasAccess(AccessActionNounEnum.LOGISTICS_MANAGEMENT, AccessActionVerbEnum.INDEX, session, req))
            return "redirect:/Login/";

        int numberClients = UserStorage.GetInstance().countClients();
        m.addAttribute("numberClients", numberClients);

        int numberAprovedJourneys = JourneyStorage.GetInstance().countJourneysApproved();
        m.addAttribute("numberAprovedJourneys", numberAprovedJourneys);

        int numberJourneysToApprove = JourneyStorage.GetInstance().countJourneysToApprove();
        m.addAttribute("numberJourneysToApprove", numberJourneysToApprove);

        // <p>${element.toString()}: ${ContainerStorage.GetNrContainers(element)}</p>

        Port[] Ports = Port.class.getEnumConstants();
        m.addAttribute("Ports", Ports);

        HashMap<String, Integer> portMap = new HashMap<>();
        for (Port p : Ports) 
            portMap.put(p.toString(), ContainerStorage.GetNrContainers(p));
        
        m.addAttribute("portMap", portMap);

        m.addAttribute("SignedUser", GetUser(session));
        return "Logistics/Index";
    }
}
