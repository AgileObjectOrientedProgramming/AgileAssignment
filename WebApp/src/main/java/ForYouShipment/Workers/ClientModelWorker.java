package ForYouShipment.Workers;

import ForYouShipment.Models.*;

public class ClientModelWorker {

    private ClientModelWorker() {}
    
    private static ClientModelWorker instance = null;

    public static ClientModelWorker GetInstance() {
        if (instance == null)
            instance = new ClientModelWorker();
        return instance;
    }

    public String UsernameIsValid(String Username) {
        /**
         * This function verifies if the username is valid is not already taken.
         * Returns null if the username is ok, otherwise returns why it is not ok.
         */
        if (Username == null) 
            return "No username!";
        if (Username.length() < 4)
            return "Username is too short!";
        if (Username.length() > 21)
            return "Username is too long!";
        if (!Username.matches("[A-Za-z0-9]+"))
            return "Please only use letters and numbers!";
        for (ClientModel i : ClientStorage.GetInstance().getUsers()) 
            if (Username.equals(i.getUsername()))
                return "Username is already taken";
        return null;
    }

    public String PasswordIsValid(String Password, String PasswordRetype) {
        /**
         * This function verifies if the password and the retyped passowrd are valid.
         * Returns null if the password is ok, otherwise returns why it is not ok.
         */
        if (Password == null) 
            return "No password!";
        if (Password.length() < 4)
            return "Password is too short!";
        if (!Password.equals(PasswordRetype))
            return "The passwords do not match";
        return null;
    }


    public String GenerateClient(String FirstName, String LastName, String Username, String Password){
        /**
         *  This function creates the user, adds it in the Client Storage and returns it's ID.
         */
        ClientModel user = new ClientModel(); 

        user.setFirstName(FirstName);
        user.setLastName(LastName);
        user.setUsername(Username);
        user.setPassword(Password);
        user.setID(IDGenerator.GetInstance().GenerateID());

        ClientStorage.GetInstance().getUsers().add(user);

        return user.getID();
    }

    public ClientModel GetClientByID(String ID) {
        for (ClientModel i : ClientStorage.GetInstance().getUsers())
            if (i.getID().equals(ID))
                return i;
        return null;
    }

    public String Authenticate(String Username, String Password) {
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
