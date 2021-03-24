package ForYouShipment.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ForYouShipment.Models.Storage;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Workers.IDGenerator;

@Controller
@RequestMapping("/Users")
public class UserController {
    
    @RequestMapping(value={ "/Index", "/", "" })
    public String Index(HttpServletRequest req, Model m) {
        List <UserModel> users = Storage.GetInstance().getUsers();

        m.addAttribute("users", users);
        return "Users/Index";
    }

    
    @RequestMapping("/New")
    public String  ReturnNewForm(HttpServletRequest req, Model m) {
        return "Users/New";
    }

    // @RequestMapping("/New")
    // public ModelAndView  ReturnNewForm(HttpServletRequest req, Model m) {
    //     return new ModelAndView("Users/New", "UserModel", new UserModel());
    // }

    @RequestMapping(value = "/New", method = RequestMethod.POST)
    public String submit(HttpServletRequest req, Model m) {
        UserModel user = new UserModel();
        user.setFirstName(req.getParameter("FirstName"));
        user.setLastName(req.getParameter("LastName"));

        user.setID(IDGenerator.GetInstance().GenerateID());

        Storage.GetInstance().getUsers().add(user);
        System.out.println("Saved new user: name = " + user.getFirstName() +
            ", last name = " + user.getLastName());

        return "redirect:/Users/Index";
    }

    // @RequestMapping(value = "/New", method = RequestMethod.POST)
    // public String submit(@Validated @ModelAttribute("UserModel") UserModel user, 
    //   BindingResult result, Model m) {
    //     if (result.hasErrors()) {
    //         System.out.println("Unable to match!");
    //         return "error";
    //     }

    //     Storage.GetInstance().getUsers().add(user);
    //     System.out.println("Saved new user: name = " + user.getFirstName() +
    //         ", last name = " + user.getLastName());

    //     m.addAttribute("users", Storage.GetInstance().getUsers());
    //     return "Users/Index";
    // }
}