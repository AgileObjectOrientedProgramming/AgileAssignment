package ForYouShipment.Models;

import ForYouShipment.Workers.IDGenerator;

public class ClientModel {
    private String FirstName, LastName, UserName, password;
    private String FullName = FirstName + LastName;
    private final String ID;
    
    public ClientModel() {
        ID = IDGenerator.GetInstance().GenerateID();
    }
    
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public String getID() {
        return ID;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String name() {return FullName;}
}
