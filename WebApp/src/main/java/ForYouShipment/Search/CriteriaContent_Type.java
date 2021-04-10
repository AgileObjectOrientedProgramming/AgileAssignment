package ForYouShipment.Search;

import java.util.ArrayList;
import java.util.List;

import ForYouShipment.Models.Journey;

public class CriteriaContent_Type implements Criteria<Journey>{
    @Override
    public List<Journey> meetCriteria(List<Journey> Journeys, String query) {
            List<Journey> Journeys_origin = new ArrayList<Journey>();
            
            for (Journey j: Journeys ){
                if(j.getContent_type().toString().toLowerCase().contains(query.toLowerCase()))
                    Journeys_origin.add(j);

            }
        return Journeys_origin;
    }
}
