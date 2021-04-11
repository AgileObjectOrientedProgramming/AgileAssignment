package ForYouShipment.Search;

import java.util.ArrayList;
import java.util.List;

import ForYouShipment.Models.JourneyInfo;

public class CriteriaOrigin implements Criteria<JourneyInfo> {

    @Override
    public List<JourneyInfo> meetCriteria(List<JourneyInfo> Journeys, String query) {
            List<JourneyInfo> Journeys_origin = new ArrayList<JourneyInfo>();
            
            for (JourneyInfo j: Journeys){
                if(j.getOrigin().toString().toLowerCase().contains(query.toLowerCase()))
                    Journeys_origin.add(j);

            }
        return Journeys_origin;
    }
}
