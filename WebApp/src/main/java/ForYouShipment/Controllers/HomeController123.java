package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Home")
public class HomeController123 {

    @RequestMapping("/Index")
    public String Index(HttpServletRequest req, Model m) {

        return "Home/Index";
    }

    @RequestMapping("/About")
    public String About() {
        return "Home/About";
    }
}
