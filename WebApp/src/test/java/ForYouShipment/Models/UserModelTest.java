package ForYouShipment.Models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UserModelTest {
    @Test
    public void IsAbleToInstantiate() {
        UserModel user = new UserModel();
        assertNotNull(user);
    }

    @Test
    public void GettersAndSettersWork() {
        UserModel user = new UserModel();
        user.setFirstName("ABC");
        assertEquals(user.getFirstName(), "ABC");

        user.setLastName("ABCD");
        assertEquals(user.getLastName(), "ABCD");

        user.setID("1234");
        assertEquals(user.getID(), "1234");
    }
}
