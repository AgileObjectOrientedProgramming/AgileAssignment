package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ForYouShipment.Workers.ClientModelGenerator;

@Controller
@RequestMapping("/Signup")
public class SignupController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String  ReturnSignupForm(HttpServletRequest req, Model m) {
        return "Signup/Index";
    }

    @RequestMapping(value ={"/Index", "/", ""}, method = RequestMethod.POST)
    public String CreateUser(HttpServletRequest req, Model m) {

        ClientModelGenerator.generateClient(req, m);

        return "redirect:/Client";
    }

}