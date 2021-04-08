package ForYouShipment.Models;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class JourneyTest {


    @Test
    public void TestGetCompany() {
        Journey j = new Journey();
        assertTrue(j.getCompany() == null);
        j.setCompany("test");
        assertTrue(j.getCompany().equals("test"));
    }
    
    @Test
    public void TestGetID() {
        Journey j = new Journey();
        assertTrue(j.getId() != null);
    }


}
