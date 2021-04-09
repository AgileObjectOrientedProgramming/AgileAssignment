package ForYouShipment.Workers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.Container;
import ForYouShipment.Models.Journey;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Storage.ContainerStorage;

public class ContainerRegisterTest {
    String origin;
    String destination;
    String content_type;
    String company;
    Container container;

    @BeforeEach
    public void SetUpJourney() {
        origin = "LISBON";
        destination = "COPENHAGEN";
        content_type = "Fragile";
        company = "Coop";
        container = ContainerStorage.GetInstance().getContainers().iterator().next();
    }

    @Test
    public void TestSetJourney() {
        
        
        ContainerRegister.setJourney(origin, destination, content_type, company, container);

        assertTrue(container.getJourney().getOrigin().equals(Port.valueOf(origin)));
    }

    @Test
    public void TestGetFreeContainer() {
        Port valid_origin = Port.LISBON;
        Port invalid_origin = Port.PORTO;

        assertTrue(ContainerRegister.getFreeContainer(valid_origin).getLocation() == valid_origin);
        assertTrue(ContainerRegister.getFreeContainer(invalid_origin) == null);
        
    }

    @Test
    public void TestReturnContainer() {
        ContainerRegister.setJourney(origin, destination, content_type, company, container);
        Journey j = container.getJourney();
        assertFalse(j == null);
        ContainerRegister.returnContainer(container);
        assertTrue(container.getJourney() == null);
        assertTrue(container.getLocation() == j.getDestination());
    }
}
