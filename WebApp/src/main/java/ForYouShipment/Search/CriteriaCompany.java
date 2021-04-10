package ForYouShipment.Search;

import java.util.ArrayList;
import java.util.List;

import ForYouShipment.Models.Journey;


public class CriteriaCompany implements Criteria<Journey>{
    
    @Override
    public List<Journey> meetCriteria(List<Journey> Journeys, String query) {
            List<Journey> Journeys_company = new ArrayList<Journey>();
            
            for (Journey j: Journeys) {
                if(j.getCompany().toString().toLowerCase().contains(query.toLowerCase()))
                    Journeys_company.add(j);

            }
        return Journeys_company;
    }
}
