package ForYouShipment.Workers;

import org.junit.jupiter.api.BeforeEach;

import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.Container;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Storage.ContainerStorage;

public class ContainerRegisterTest {
    String origin;
    String destination;
    String content_type;
    String company;
    Container container;
    UserModel user;

    @BeforeEach
    public void SetUpJourney() {
        origin = "LISBON";
        destination = "COPENHAGEN";
        content_type = "Fragile";
        company = "Coop";
        container = ContainerStorage.GetInstance().getContainers().iterator().next();
        user = new ClientUserModel();
        user.setUsername("Test");
        user.setID("1.1.1.1");
    }

    //FIXME
    // @Test
    // public void TestSetJourney() throws Exception {
        
    //     Container c = ContainerRegister.setJourney(origin, destination, content_type, company, user);

    //     assertTrue(c.getJourney().getOrigin().equals(Port.valueOf(origin)));
    // }

    // @Test
    // public void TestGetFreeContainer() {
    //     Port valid_origin = Port.LISBON;
    //     Port invalid_origin = Port.PORTO;

    //     assertTrue(ContainerRegister.getFreeContainer(valid_origin).getLocation() == valid_origin);
    //     assertTrue(ContainerRegister.getFreeContainer(invalid_origin) == null);
        
    // }

    //FIXME
    // @Test
    // public void TestReturnContainer() throws Exception {
    //     Container c = ContainerRegister.setJourney(origin, destination, content_type, company, user);
    //     JourneyInfo j = c.getJourney();
    //     assertFalse(j == null);
    //     ContainerRegister.returnContainer(c);
    //     assertTrue(c.getJourney() == null);
    //     assertTrue(c.getLocation() == j.getDestination());
    // }
}
