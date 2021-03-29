package ForYouShipment.Models;

import ForYouShipment.Interfaces.ClientUI;
import ForYouShipment.Workers.IDGenerator;


//** This is the Client Model */
public class ClientModel implements ClientUI{
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

    public void setFirstName(final String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(final String lastName) {
        LastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(final String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(final String Password) {
        this.Password = Password;
    }

    public String getID() {
        return ID;
    }

    public void setID(final String ID) {
        this.ID = ID;
    }
}
