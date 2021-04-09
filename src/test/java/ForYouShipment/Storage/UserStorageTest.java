package ForYouShipment.Storage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.UserModel;

public class UserStorageTest {
    @BeforeEach
    public void SetUpUsers() {
        UserModel a = new ClientUserModel();
        a.setID("1.2.3.4");
        a.setUsername("1234");
        a.setPassword("1234");

        UserStorage.GetInstance().getUsers().add(a);
    }
    @Test
    public void TestgetUsers() {
        assertTrue(
            UserStorage
            .GetInstance()
            .getUsers()
            .iterator()
            .next()
            .getID()
            .equals("1.2.3.4")
        );
    }

    @Test
    public void TestsetUsers() {
        UserStorage.GetInstance().setUsers(new HashSet<>());
        assertTrue(
            UserStorage
            .GetInstance()
            .getUsers()
            .size() == 0
        );
    }

    @AfterEach
    public void ClearGarbage() {
        UserStorage.GetInstance().getUsers().clear();
    }
}
