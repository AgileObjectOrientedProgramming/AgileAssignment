package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ForYouShipment.RefactoredControllers.SignupFacade;

@Controller
@RequestMapping("/Signup")
public class SignupController extends BaseController {

    @RequestMapping(value={ "/Index", "/", "" })
    public String  ReturnSignupForm(HttpServletRequest req, Model m, HttpSession session) {
        return SignupFacade.ReturnSignupForm(req, m, session);
    }

    @RequestMapping(value ={"/CreateUser"}, method = RequestMethod.POST)
    public String CreateUser(HttpServletRequest req, Model m, HttpSession session, 
                            @RequestParam("Username") String Username,
                            @RequestParam("Password") String Password,
                            @RequestParam("PasswordRetype") String PasswordRetype) {
        
        return SignupFacade.createUser(req, m, session, Username, Password, PasswordRetype);
    }
}