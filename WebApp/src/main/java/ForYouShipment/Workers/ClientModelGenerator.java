package ForYouShipment.Workers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import ForYouShipment.Models.*;

public class ClientModelGenerator {

    public static void generateClient(HttpServletRequest req, Model m){
        ClientModel user = new ClientModel();  
        user.setFirstName(req.getParameter("FirstName"));
        user.setLastName(req.getParameter("LastName"));
        user.setUserName(req.getParameter("UserName"));
        user.setPassword(req.getParameter("Password"));

        ClientStorage.GetInstance().getUsers().add(user);

        //Testing - Delete Later
        System.out.println("Saved new user: name = " + user.name());
        //

    }

}
