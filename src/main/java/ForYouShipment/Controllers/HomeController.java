package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {

    @RequestMapping({"/", ""})
    public String Index(HttpServletRequest req, Model m, HttpSession session) {
        m.addAttribute("SignedUser", GetUser(session));
        return "Home/Index";
    }

}
