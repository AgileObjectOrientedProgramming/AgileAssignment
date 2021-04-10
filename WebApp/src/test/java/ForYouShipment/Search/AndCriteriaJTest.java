package ForYouShipment.Search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.Journey;

public class AndCriteriaJTest {

    @Test
    public void TestMeetCriteria() {
        List<Journey> journeys = new ArrayList<>();
        Journey j1 = new Journey();
        Journey j2 = new Journey();

        j1.setOrigin(Port.COPENHAGEN);
        j2.setOrigin(Port.CAPETOWN);
        
        j1.setDestination(Port.COPENHAGEN);
        j2.setDestination(Port.COPENHAGEN);
        

        journeys.add(j1);
        journeys.add(j2);
        

        Criteria<Journey> o1 = new CriteriaOrigin();
        Criteria<Journey> o2 = new CriteriaDestination();
        Criteria<Journey> and = new AndCriteriaJ(o1, o2);
        journeys = and.meetCriteria(journeys, "Copen");
        assertTrue(journeys.size() == 1);

    }
    
}
