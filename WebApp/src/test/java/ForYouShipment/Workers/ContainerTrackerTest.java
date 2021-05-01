package ForYouShipment.Workers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.ContainerMeasurements;
import ForYouShipment.Models.JourneyInfo;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Storage.ContainerStorage;

public class ContainerTrackerTest {
    
        String origin;
        String destination;
        String content_type;
        String company;
        ContainerMeasurements container;
        UserModel user;
      

        @Test
        public void setMeasurementsTest(){
            ContainerStorage.addContainers(5, Port.LISBON );
            container = ContainerStorage.GetInstance().getContainers().iterator().next();
            Map<String,String> measurements = new HashMap<>();
            measurements.put("Temperature", "2");
            JourneyInfo journey = new JourneyInfo();
            container.setJourney(journey);
            String jid = journey.getId();
            ContainerMeasurements c = new ContainerMeasurements();
            c = ContainerTracker.setMeasurements(measurements, journey);
            assertTrue(c.getParameters().equals(measurements));
        }

}
