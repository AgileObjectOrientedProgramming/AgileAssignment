package ForYouShipment.Storage;

import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.HashSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import ForYouShipment.Constants.Port;



public class ContainerStorageTest {

    
    @Test
    public void TestgetUsers() {
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
        UserStorage.GetInstance().setUsers(new HashSet<>());
        assertTrue(
            UserStorage
            .GetInstance()
            .getUsers()
            .size() == 0
        );
    }

    @BeforeEach
    public void ClearGarbage() {
        ContainerStorage.GetInstance().getContainers().clear();
        ContainerStorage.addContainers(ContainerStorage.GetInstance(), 200 , Port.LISBON);
    }
}
