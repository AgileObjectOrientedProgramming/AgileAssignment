package ForYouShipment.Search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ForYouShipment.Models.Journey;

public class CriteriaCompanyTest {


    
    @Test
    public void TestMeetCriteria() {
        List<Journey> journeys = new ArrayList<>();
        Journey j = new Journey();
        Journey j2 = new Journey();
        j.setCompany("Test company");
        j2.setCompany("company");
        journeys.add(j);
        journeys.add(j2);
        Criteria<Journey> c = new CriteriaCompany();
        List<Journey> companyJourneys = c.meetCriteria(journeys, "Test");
        assertTrue(companyJourneys.size() == 1);

        
    }
    
}
