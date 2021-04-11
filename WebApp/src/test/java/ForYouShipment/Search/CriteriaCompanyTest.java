package ForYouShipment.Search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ForYouShipment.Models.JourneyInfo;

public class CriteriaCompanyTest {


    
    @Test
    public void TestMeetCriteria() {
        List<JourneyInfo > journeys = new ArrayList<>();
        JourneyInfo j = new JourneyInfo();
        JourneyInfo j2 = new JourneyInfo();
        j.setCompany("Test");
        j2.setCompany("company");
        journeys.add(j);
        journeys.add(j2);
        Criteria<JourneyInfo > c = new CriteriaCompany();
        journeys = c.meetCriteria(journeys, "Test");
        assertTrue(journeys.size() == 1);

        
    }
    
}
