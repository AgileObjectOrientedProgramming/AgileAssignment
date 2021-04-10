package ForYouShipment.Search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ForYouShipment.Models.Journey;
import ForYouShipment.Models.JourneyInfo;

public class CriteriaUserTest {


    
    @Test
    public void TestMeetCriteria() {
        List<Journey> journeys = new ArrayList<>();
        Journey j = new Journey();
        Journey j2 = new Journey();
        JourneyInfo ji = new JourneyInfo();
        JourneyInfo ji2 = new JourneyInfo();
        ji.setParameter("Username", "Test");
        j.setInfo(ji);
        ji2.setParameter("Username", "mmm");
        j2.setInfo(ji2);
        journeys.add(j);
        journeys.add(j2);
        Criteria<Journey> c = new CriteriaUser();
        journeys = c.meetCriteria(journeys, "Test");
        for (Journey jajaj : journeys) {
            System.out.println(jajaj.getInfo().getParameter("Username"));
        }
        System.out.println(journeys.size());
        assertTrue(journeys.size() == 1);

        
    }
    
}
