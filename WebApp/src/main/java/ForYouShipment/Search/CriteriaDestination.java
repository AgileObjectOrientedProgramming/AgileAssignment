package ForYouShipment.Search;

import java.util.ArrayList;
import java.util.List;

import ForYouShipment.Models.Journey;

public class CriteriaDestination implements Criteria<Journey> {
 
    @Override
    public List<Journey> meetCriteria(List<Journey> Journeys, String query) {
            List<Journey> Journeys_destination = new ArrayList<Journey>();
            
            for (Journey j: Journeys ){
                if(j.getDestination().toString().toLowerCase().contains(query.toLowerCase()))
                    Journeys_destination.add(j);

            }
        return Journeys_destination;
    }
}
