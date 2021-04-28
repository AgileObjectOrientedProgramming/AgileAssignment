// package ForYouShipment.Storage;

// import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Map;

// import org.json.*;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import ForYouShipment.Constants.Port;
// import ForYouShipment.Models.ClientProfileModel;
// import ForYouShipment.Models.ClientUserModel;
// import ForYouShipment.Models.ContainerMeasurements;
// import ForYouShipment.Models.UserModel;
// import ForYouShipment.Workers.ContainerRegister;



// public class ContainerStorageTest {

    
//     @Test
//     public void TestgetContainers() {
//         assertTrue(
//             ContainerStorage
//             .GetInstance()
//             .getContainers()
//             .iterator()
//             .next()
//             .getLocation() == Port.LISBON);
        
//     }

//     @Test
//     public void TestsetContainers() {
//         ContainerStorage.GetInstance().setContainers(new HashSet<>());
//         assertTrue(
//             ContainerStorage
//             .GetInstance()
//             .getContainers()
//             .size() == 0
//         );
//     }

//     @Test
//     public void TestPersitence() throws Exception {
//         UserModel u = new ClientUserModel();
//         u.setUsername("ola");
//         u.setPassword("test");
//         u.setProfile(new ClientProfileModel());
//         u.setID("12345");
        
//         ContainerMeasurements c = ContainerRegister.setJourney("Lisbon",
//                                      "Porto", 
//                                     "Fragile", 
//                                     "ASD",
//                                     u);
//         Map<String, String> measurements = new HashMap<>();
//         measurements.put("Temperature", "10");
//         measurements.put("Pressure", "100");
//         c.saveMeasurements(measurements);
//         Map<String, String> measurements2 = new HashMap<>();
//         measurements2.put("Temperature", "11");
//         measurements2.put("Pressure", "101");
//         c.saveMeasurements(measurements2);
//         Map<String, String> measurements3 = new HashMap<>();
//         measurements3.put("Temperature", "12");
//         measurements3.put("Pressure", "102");
//         c.saveMeasurements(measurements3);
//         JSONArray o = ContainerStorage.GetInstance().SaveContentToJSON();
//         System.out.println(o.toString());
//     }

//     @Test
//     public void TestPersitence2() throws Exception {
    
//     }

//     @BeforeEach
//     public void ClearGarbage() {
//         ContainerStorage.GetInstance().getContainers().clear();
//         ContainerStorage.addContainers( 200 , Port.LISBON);
//     }
// }
