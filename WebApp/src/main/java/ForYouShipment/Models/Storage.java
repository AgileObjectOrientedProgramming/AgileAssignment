package ForYouShipment.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class storing all ForYouShipment Users.
 */
public class Storage {

    // Items to save.
    private List <UserModel> Users;

    private Storage() {
        Users = new ArrayList<>();
    }

    public List<UserModel> getUsers() {
        return Users;
    }

    public void setUsers(List<UserModel> users) {
        Users = users;
    }

    private static Storage instance = null;

    public static Storage GetInstance() {
        if (instance == null)
            instance = new Storage();
        return instance;
    }
}
