package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ForYouShipment.Workers.ClientModelWorker;

@Controller
@RequestMapping("/Signup")
public class SignupController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String  ReturnSignupForm(HttpServletRequest req, Model m) {
        return "Signup/Index";
    }

    @RequestMapping(value ={"/CreateUser"}, method = RequestMethod.POST)
    public String CreateUser(HttpServletRequest req, Model m, HttpSession session,
            @RequestParam("FirstName") String FirstName,
            @RequestParam("LastName") String LastName,
            @RequestParam("Username") String Username,
            @RequestParam("Password") String Password,
            @RequestParam("PasswordRetype") String PasswordRetype) {
        
        UserModel user = new ClientUserModel();

        System.out.println("Got " + FirstName);
        String UsernameCheckResult = ClientModelWorker.GetInstance().UsernameIsValid(Username);
        if (UsernameCheckResult != null) {
            m.addAttribute("warning", UsernameCheckResult);
            return "Signup/Index";
        }
        String PasswordCheckResult = ClientModelWorker.GetInstance().PasswordIsValid(Password, PasswordRetype);
        if (PasswordCheckResult != null) {
            m.addAttribute("warning", PasswordCheckResult);
            return "Signup/Index";
        }

        String ID = ClientModelWorker.GetInstance().GenerateClient(FirstName, LastName, Username, Password);

        session.setAttribute("SignedUser", ID);

        return "redirect:/Client";
    }
}