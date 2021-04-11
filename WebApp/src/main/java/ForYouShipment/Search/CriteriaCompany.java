package ForYouShipment.Search;

import java.util.ArrayList;
import java.util.List;

import ForYouShipment.Models.JourneyInfo;


public class CriteriaCompany implements Criteria<JourneyInfo>{
    
    @Override
    public List<JourneyInfo> meetCriteria(List<JourneyInfo> Journeys, String query) {
            List<JourneyInfo> Journeys_company = new ArrayList<JourneyInfo>();
            
            for (JourneyInfo j: Journeys) {
                if(j.getCompany().toString().toLowerCase().contains(query.toLowerCase()))
                    Journeys_company.add(j);

            }
        return Journeys_company;
    }
}
