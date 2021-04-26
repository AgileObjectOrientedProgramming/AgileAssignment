package ForYouShipment.Facade;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import ForYouShipment.Constants.Port;
import ForYouShipment.Storage.ContainerStorage;

public class HomeFacade extends Facade {
    
    public static String WorldMap(Model m, HttpSession session) {
        m.addAttribute("Containers", ContainerStorage.getUsedContainers());
        m.addAttribute("ports", Port.class.getEnumConstants());               
        m.addAttribute("SignedUser", GetUser(session));
        return "Home/WorldMap";
    }
    
    
}
