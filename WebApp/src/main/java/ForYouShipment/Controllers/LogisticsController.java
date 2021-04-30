package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ForYouShipment.Facade.LogisticsFacade;



@Controller
@RequestMapping("/Logistics")
public class LogisticsController extends BaseController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m, HttpSession session) throws Exception{
        return LogisticsFacade.Index(req, m, session);
    }

}
