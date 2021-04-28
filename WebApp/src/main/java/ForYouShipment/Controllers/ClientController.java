package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ForYouShipment.Facade.ClientFacade;


@Controller
@RequestMapping("/Client")
public class ClientController extends BaseController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) {

        return ClientFacade.Index(req, m, session);
  
    }

    // Should always have the ID param /Client/View?ID=1.2.3.4.
    @RequestMapping(value={ "/View" })
    public String View(HttpServletRequest req, Model m, HttpSession session,
                    @RequestParam("ID") String ProfileID) {

        return ClientFacade.View(req, m, session, ProfileID);
    }


    @RequestMapping(value={ "/Search" })
    public String Search(HttpServletRequest req, Model m, HttpSession session) {

        return ClientFacade.Search(req, m, session);
    }


    @RequestMapping(value={ "/Delete" })
    public String Delete(HttpServletRequest req, Model m, HttpSession session,
                        @RequestParam("ID") String ID) {

        return ClientFacade.Delete(req, session, ID);
    }


    @RequestMapping(value={ "/Edit" }) 
    public String Edit(HttpServletRequest req, Model m, HttpSession session) {

        return ClientFacade.Edit(req, m, session);
    }


    @RequestMapping(value={ "/Edit" }, method = RequestMethod.POST) 
    public String Edit(HttpServletRequest req, Model m, HttpSession session,
                @RequestParam("Password") String Password,
                @RequestParam("PasswordRetype") String PasswordRetype) {

        return ClientFacade.EditPost(req, m, session, Password, PasswordRetype);
    }

}
