
package ForYouShipment.Models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientModelTest {

    private ClientModel client;

    @BeforeEach
    public void generateClient(){
        client = new ClientModel();
    }
    
    
    @Test
    public void IsAbleToInstantiate() {
        assertNotNull(client);
    }

    @Test
    public void GettersAndSettersWork() {
        client.setFirstName("ABC");
        assertEquals(client.getFirstName(), "ABC");

        client.setLastName("ABCD");
        assertEquals(client.getLastName(), "ABCD");

        client.setID("1234");
        assertEquals(client.getID(), "1234");
    }

    @Test 
    public void GeneratesName(){
        client.setFirstName("A");
        client.setLastName("B");
        assertEquals(client.GenerateName(), "A B");
    }
}
