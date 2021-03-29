package ForYouShipment.Storage;

import java.util.ArrayList;
import java.util.List;

import ForYouShipment.Models.UserModel;

/**
 * Singleton class storing all ForYouShipment Users.
 */
public class UserStorage implements Storage {

    // Items to save.
    private List <UserModel> Users;

    private UserStorage() {
        Users = new ArrayList<>();
    }

    public List<UserModel> getUsers() {
        return Users;
    }

    public void setUsers(List<UserModel> users) {
        Users = users;
    }

    private static UserStorage instance = null;

    public static UserStorage GetInstance() {
        if (instance == null)
            instance = new UserStorage();
        return instance;
    }
}
