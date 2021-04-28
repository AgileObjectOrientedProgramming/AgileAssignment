package ForYouShipment.Facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ForYouShipment.Constants.AccessActionNounEnum;
import ForYouShipment.Constants.AccessActionVerbEnum;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Workers.AuthenticateUserWorker;
import ForYouShipment.Workers.SecurityAccessWorker;

public class Facade {
    
    protected static boolean HasAccess(AccessActionNounEnum noun, AccessActionVerbEnum verb, 
    HttpSession session, HttpServletRequest req) {

    String ID = (String) session.getAttribute("SignedUser");
    UserModel user = AuthenticateUserWorker.GetUserByID(ID);

    return SecurityAccessWorker.HasAccessTo(noun, verb, user);
    }


    /**
    * This function returns the signed user.
    * @param session
    * @return user if signed in / null else
    */
    protected static UserModel GetUser(HttpSession session) {
    String ID = (String) session.getAttribute("SignedUser");

    UserModel user = AuthenticateUserWorker.GetUserByID(ID);

    return user;

    }
}
