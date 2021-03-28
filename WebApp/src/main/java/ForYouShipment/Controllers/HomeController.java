package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("")
    public String Index(HttpServletRequest req, Model m) {

        return "Home/Index";
    }

    @RequestMapping("/About")
    public String About() {
        return "Home/About";
    }
}
