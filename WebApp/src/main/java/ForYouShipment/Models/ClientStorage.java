package ForYouShipment.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class storing all Clients users.
 */
public class ClientStorage {

    // Items to save.
    private List <ClientModel> Clients;

    private ClientStorage() {
        Clients = new ArrayList<>();
    }

    public List<ClientModel> getUsers() {
        return Clients;
    }

    public void setUsers(List<ClientModel> clients) {
        Clients = clients;
    }

    private static ClientStorage instance = null;

    public static ClientStorage GetInstance() {
        if (instance == null)
            instance = new ClientStorage();
        return instance;
    }
}
