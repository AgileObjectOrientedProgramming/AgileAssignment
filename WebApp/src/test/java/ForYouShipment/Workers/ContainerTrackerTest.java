package ForYouShipment.Workers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import ForYouShipment.Models.ContainerMeasurements;
import ForYouShipment.Models.JourneyInfo;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Search.Criteria;
import ForYouShipment.Search.CriteriaJourney;
import ForYouShipment.Storage.ContainerStorage;

public class ContainerTrackerTest {

        String origin;
        String destination;
        String content_type;
        String company;
        ContainerMeasurements container;
        UserModel user;
      

        @Test //FIXME
        public void setMeasurementsTest(){
            container = new ContainerMeasurements();
            JourneyInfo j = new JourneyInfo("");
            j.setId("1234"); 
            container.setJourney(j);
            ContainerStorage.GetInstance().getContainers().add(container);
            Map<String, String> measurements = new HashMap<>();
            ContainerMeasurements c = ContainerTracker.setMeasurements(measurements, j);
            assertEquals(c.getJourney().getId(),"1234");
        }

}
