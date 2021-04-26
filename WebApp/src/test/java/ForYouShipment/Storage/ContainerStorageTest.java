package ForYouShipment.Storage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;

import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Workers.ContainerRegister;



public class ContainerStorageTest {

    
    @Test
    public void TestgetContainers() {
        assertTrue(
            ContainerStorage
            .GetInstance()
            .getContainers()
            .iterator()
            .next()
            .getLocation() == Port.LISBON);
        
    }

    @Test
    public void TestsetContainers() {
        ContainerStorage.GetInstance().setContainers(new HashSet<>());
        assertTrue(
            ContainerStorage
            .GetInstance()
            .getContainers()
            .size() == 0
        );
    }

    @Test
    public void TestPersitence() throws Exception {
        UserModel u = new ClientUserModel();
        
        ContainerRegister.setJourney("Lisbon",
                                     "Porto", 
                                    "Fragile", 
                                    "ASD",
                                    u);
                                    
        JSONArray o = ContainerStorage.GetInstance().SaveContentToJSON();
        System.out.println(o.toString());
    }

    @BeforeEach
    public void ClearGarbage() {
        ContainerStorage.GetInstance().getContainers().clear();
        ContainerStorage.addContainers( 200 , Port.LISBON);
    }
}
