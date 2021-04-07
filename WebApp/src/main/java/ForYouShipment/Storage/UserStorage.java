package ForYouShipment.Storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ForYouShipment.Models.UserModel;

/**
 * Singleton class storing all informations.
 */
public class UserStorage implements Storage {

    // Items to save.
    private Set <UserModel> Users;

    private UserStorage() {
        Users = new HashSet<>();
    }

    public Set<UserModel> getUsers() {
        return Users;
    }

    public void setUsers(Set<UserModel> users) {
        Users = users;
    }

    private static UserStorage instance = null;

    public static UserStorage GetInstance() {
        if (instance == null)
            instance = new UserStorage();
        return instance;
    }
}
