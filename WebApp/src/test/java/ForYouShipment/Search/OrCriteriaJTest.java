package ForYouShipment.Search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.Journey;

public class OrCriteriaJTest {

    @Test
    public void TestMeetCriteria() {
        List<Journey> journeys = new ArrayList<>();
        Journey j1 = new Journey();
        Journey j2 = new Journey();
        Journey j3 = new Journey();

        j1.setOrigin(Port.AMSTERDAM);
        j2.setOrigin(Port.CAPETOWN);
        j3.setOrigin(Port.SHANGAI);
        
        j1.setDestination(Port.CAPETOWN);
        j2.setDestination(Port.PORTO);
        j3.setDestination(Port.NEW_YORK);
        

        journeys.add(j1);
        journeys.add(j2);
        journeys.add(j3);
        

        Criteria<Journey> o1 = new CriteriaOrigin();
        Criteria<Journey> o2 = new CriteriaDestination();
        Criteria<Journey> or = new OrCriteriaJ(o1, o2);
        journeys = or.meetCriteria(journeys, "Cape");
        assertTrue(journeys.size() == 2);

    }

    @Test
    public void TestMeetCriteriaNeg() {
        List<Journey> journeys = new ArrayList<>();
        Journey j1 = new Journey();
        Journey j2 = new Journey();
        Journey j3 = new Journey();

        j1.setOrigin(Port.CAPETOWN);
        j2.setOrigin(Port.SYDNEY);
        j3.setOrigin(Port.SHANGAI);
        
        j1.setDestination(Port.CAPETOWN);
        j2.setDestination(Port.PORTO);
        j3.setDestination(Port.NEW_YORK);
        

        journeys.add(j1);
        journeys.add(j2);
        journeys.add(j3);
        

        Criteria<Journey> o1 = new CriteriaOrigin();
        Criteria<Journey> o2 = new CriteriaDestination();
        Criteria<Journey> or = new OrCriteriaJ(o1, o2);
        journeys = or.meetCriteria(journeys, "Cape");
        assertTrue(journeys.size() == 1);

    }
    
}
