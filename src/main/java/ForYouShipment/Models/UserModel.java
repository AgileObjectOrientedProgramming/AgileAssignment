package ForYouShipment.Models;

public abstract class UserModel {
    private String Username, Password, ID;
    private UserProfileModel Profile;

    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public UserProfileModel getProfile() {
        return Profile;
    }
    public void setProfile(UserProfileModel profile) {
        Profile = profile;
    }

    /**
     * Returns if the user should be allowed to access a certain path or not.
     * Ex: ClientUserModel should not have access to "/Admin" but should have access to "/Client". 
     */
    public abstract boolean HasAccessTo(String Path);

    public abstract boolean IsLogisticUser();
}
