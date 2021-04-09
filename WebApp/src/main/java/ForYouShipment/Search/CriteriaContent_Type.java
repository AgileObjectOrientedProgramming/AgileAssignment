package ForYouShipment.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ForYouShipment.Models.Journey;
import ForYouShipment.Storage.JourneyStorage;

public class CriteriaContent_Type implements Criteria<Journey>{
    @Override
    public List<Journey> meetCriteria(List<Journey> Journeys, String query) {
            List<Journey> Journeys_origin = new ArrayList<Journey>();
            
            for (Journey j: JourneyStorage.GetInstance().getJourneys() ){
                if(j.getContent_type().toString().contains(query))
                    Journeys_origin.add(j);

            }
        return Journeys_origin;
    }
}
