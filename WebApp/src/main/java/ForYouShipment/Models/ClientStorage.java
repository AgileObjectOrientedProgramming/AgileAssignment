package ForYouShipment.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class storing all informations.
 */
public class ClientStorage {

    // Items to save.
    private List <ClientModel> Users;

    private ClientStorage() {
        Users = new ArrayList<>();
    }

    public List<ClientModel> getUsers() {
        return Users;
    }

    public void setUsers(List<ClientModel> users) {
        Users = users;
    }

    private static ClientStorage instance = null;

    public static ClientStorage GetInstance() {
        if (instance == null)
            instance = new ClientStorage();
        return instance;
    }
}
