package ForYouShipment.Search;

import java.util.ArrayList;
import java.util.List;

import ForYouShipment.Models.Journey;

public class CriteriaUser implements Criteria<Journey> {

    @Override
    public List<Journey> meetCriteria(List<Journey> Journeys, String query) {
            List<Journey> Journeys_User = new ArrayList<Journey>();
            
            for (Journey j: Journeys){
                System.out.println(query);
                if(j.getInfo().getParameter("Username").toLowerCase().contains(query.toLowerCase()))
                    Journeys_User.add(j);
            }
            
        return Journeys_User;
    }
    
}
