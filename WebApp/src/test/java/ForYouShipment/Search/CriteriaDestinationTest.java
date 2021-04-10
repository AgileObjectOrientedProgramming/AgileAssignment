package ForYouShipment.Search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.Journey;

public class CriteriaDestinationTest {


    
    @Test
    public void TestMeetCriteria() {
        List<Journey> journeys = new ArrayList<>();
        Journey j = new Journey();
        Journey j2 = new Journey();
        j.setDestination(Port.AMSTERDAM);
        j2.setDestination(Port.CAPETOWN);
        journeys.add(j);
        journeys.add(j2);
        Criteria<Journey> c = new CriteriaDestination();
        journeys = c.meetCriteria(journeys, "Ams");
        assertTrue(journeys.size() == 1);

        
    }
    
}