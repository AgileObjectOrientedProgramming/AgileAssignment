package ForYouShipment.Models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StorageTest {
    @Test
    public void AllInstancesAreEqual() {
        Storage a = Storage.GetInstance();
        Storage b = Storage.GetInstance();

        assertEquals(a, b);
    }

    @Test
    public void UserArrayIsInitialised() {
        assertNotNull(Storage.GetInstance().getUsers());
    }

    @Test
    public void GettersAndSettersWork() {
        List <UserModel> users = new ArrayList<>();
        users.add(new UserModel());
        users.get(0).setID("1234");
        Storage.GetInstance().setUsers(users);

        assertEquals(
            Storage.GetInstance()
                .getUsers()
                    .get(0)
                        .getID(), "1234");
    }
}
