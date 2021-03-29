package ForYouShipment.Workers;

import ForYouShipment.Models.ClientModel;
import ForYouShipment.Models.ClientStorage;

/** This is  */
public class AuthenticateClientWorker {

    
    private AuthenticateClientWorker() {} //Emma it works as private

    /**  */
    public static String Authenticate(String Username, String Password) {
        /**
         * If the username and password matches client, then return the ID,
         * otherwise, return null.
         */
        for (ClientModel i : ClientStorage.GetInstance().getUsers())
            if (i.getUsername().equals(Username) && i.getPassword().equals(Password)) 
                return i.getID();
        return null;
    }
}
