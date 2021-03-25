package ForYouShipment.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/View")
    public String  DisplayUser(HttpServletRequest req, Model m) {
        List <UserModel> users = Storage.GetInstance().getUsers();
        UserModel user = null;
        String id = req.getParameter("ID");

        for (UserModel u : users)
            if (u.getID().equals(id))
                user = u;

        if (user == null)
            return "redirect:/Users/Index";
        
        m.addAttribute("user", user);
        return "Users/View";
    }
    
    @RequestMapping("/New")
    public String  ReturnNewForm(HttpServletRequest req, Model m) {
        // m.addAttribute("warning", "");
        return "Users/New";
    }

    @RequestMapping("/Edit")
    public String ReturnEditForm(HttpServletRequest req, Model m) {
        String id = req.getParameter("ID");
        UserModel user = null;
        List <UserModel> users = Storage.GetInstance().getUsers();
        for (int i = 0; i < users.size(); i++) 
            if (users.get(i).getID().equals(id))
                user = users.get(i);
        
        m.addAttribute("user", user);
        return "Users/Edit";
    }

    @RequestMapping(value = "/Edit", method = RequestMethod.POST)
    public String EditUser(HttpServletRequest req, Model m) {
        UserModel user = new UserModel();
        user.setFirstName(req.getParameter("FirstName"));
        user.setLastName(req.getParameter("LastName"));

        if (user.getFirstName().length() > 15) {
            m.addAttribute("warning", "Please enter a shorter first name");

            m.addAttribute("user", user);
            return "Users/Edit";
        }

        user.setID(req.getParameter("ID"));
        List <UserModel> users = Storage.GetInstance().getUsers();
        for(int i = 0; i < users.size(); i++)
            if (users.get(i).getID().equals(user.getID())) 
                users.set(i, user);

        System.out.println("Saved new user: name = " + user.getFirstName() +
            ", last name = " + user.getLastName());

        return "redirect:/Users/Index";
    }
    

    @RequestMapping(value = "/New", method = RequestMethod.POST)
    public String CreateUser(HttpServletRequest req, Model m) {
        UserModel user = new UserModel();
        user.setFirstName(req.getParameter("FirstName"));
        user.setLastName(req.getParameter("LastName"));

        if (user.getFirstName().length() > 15) {
            m.addAttribute("warning", "Please enter a shorter first name");
            return "Users/New";
        }

        user.setID(IDGenerator.GetInstance().GenerateID());

        Storage.GetInstance().getUsers().add(user);
        System.out.println("Saved new user: name = " + user.getFirstName() +
            ", last name = " + user.getLastName());

        return "redirect:/Users/Index";
    }

    @RequestMapping(value = "/Delete", method = RequestMethod.POST)
    public String DeleteUser(HttpServletRequest req, Model m) {
        String id = req.getParameter("ID");
        List <UserModel> users = Storage.GetInstance().getUsers();
        for (int i = 0; i < users.size(); i++) 
            if (users.get(i).getID().equals(id))
                users.remove(i);
        return "redirect:/Users/Index";
    }
}
