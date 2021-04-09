package ForYouShipment.Search;

import java.util.ArrayList;
import java.util.List;

import ForYouShipment.Models.Journey;
import ForYouShipment.Storage.JourneyStorage;

public class CriteriaDestination implements Criteria<Journey> {
 
    @Override
    public List<Journey> meetCriteria(List<Journey> Journeys, String query) {
            List<Journey> Journeys_destination = new ArrayList<Journey>();
            
            for (Journey j: JourneyStorage.GetInstance().getJourneys() ){
                if(j.getDestination().toString().contains(query))
                    Journeys_destination.add(j);

            }
        return Journeys_destination;
    }
}
