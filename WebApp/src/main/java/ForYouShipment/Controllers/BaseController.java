package ForYouShipment.Controllers;

import javax.servlet.http.HttpSession;

import ForYouShipment.Models.UserModel;
import ForYouShipment.Workers.AuthenticateUserWorker;

public class BaseController {
    /**
     * This function returs true if the user has access to a specific page. 
     */
    protected boolean HasAccess(String Path, HttpSession session) {

        if (session.getAttribute("SignedUser") == null)
            return false;
        
        String ID = (String) session.getAttribute("SignedUser");

        UserModel user = AuthenticateUserWorker.GetUserByID(ID);

        // Checking if the user has access
        if (!user.HasAccessTo(Path))
            return false;
            
        return true;
        
    }

    protected UserModel GetUser(HttpSession session) {
        String ID = (String) session.getAttribute("SignedUser");

        UserModel user = AuthenticateUserWorker.GetUserByID(ID);

        return user;

    }
}
