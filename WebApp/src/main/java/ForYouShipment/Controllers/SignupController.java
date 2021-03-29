package ForYouShipment.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

<<<<<<< HEAD
import ForYouShipment.Models.ClientProfileModel;
import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Storage.UserStorage;
import ForYouShipment.Workers.IDGenerator;
import ForYouShipment.Workers.ValidationWorker;
=======
import ForYouShipment.Workers.Login;
>>>>>>> 9ea1561... testing

@Controller
@RequestMapping("/Signup")
public class SignupController extends BaseController {

    @RequestMapping(value={ "/Index", "/", "" })
    public String  ReturnSignupForm(HttpServletRequest req, Model m, HttpSession session) {
        if (!HasAccess("/Signup", session)) 
            return "redirect:/Login";
        return "Signup/Index";
    }

    @RequestMapping(value ={"/CreateUser"}, method = RequestMethod.POST)
    public String CreateUser(HttpServletRequest req, Model m, HttpSession session, 
                            @RequestParam("Username") String Username,
                            @RequestParam("Password") String Password,
                            @RequestParam("PasswordRetype") String PasswordRetype) {
        
        if (!HasAccess("/Signup", session)) 
            return "redirect:/Login";

        UserModel user = new ClientUserModel();

<<<<<<< HEAD
        String UsernameCheckResult = ValidationWorker.UsernameIsValid(Username);
=======
        System.out.println("Got " + FirstName);
        String UsernameCheckResult = Login.UsernameIsValid(Username);
>>>>>>> 9ea1561... testing
        if (UsernameCheckResult != null) {
            m.addAttribute("warning", UsernameCheckResult);
            return "Signup/Index";
        }
<<<<<<< HEAD
        String PasswordCheckResult = ValidationWorker.PasswordIsValid(Password, PasswordRetype);
=======
        String PasswordCheckResult = Login.PasswordIsValid(Password, PasswordRetype);
>>>>>>> 9ea1561... testing
        if (PasswordCheckResult != null) {
            m.addAttribute("warning", PasswordCheckResult);
            return "Signup/Index";
        }

<<<<<<< HEAD
        String ID = IDGenerator.GenerateID();
=======
        String ID = Login.GenerateClient(FirstName, LastName, Username, Password);
>>>>>>> 9ea1561... testing

        user.setID(ID);
        user.setUsername(Username);
        user.setPassword(Password);
        user.setProfile(new ClientProfileModel());
        
        UserStorage.GetInstance().getUsers().add(user);

        return "redirect:/Client";
    }
}