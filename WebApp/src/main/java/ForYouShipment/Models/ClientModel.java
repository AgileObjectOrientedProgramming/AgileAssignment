package ForYouShipment.Models;

import ForYouShipment.Workers.IDGenerator;

public class ClientModel {
    private String FirstName, LastName, Username, Password, ID;
    
    public ClientModel() {
        ID = IDGenerator.GetInstance().GenerateID();
    }

    public String GenerateName() {
        return FirstName + " " + LastName;
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

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
