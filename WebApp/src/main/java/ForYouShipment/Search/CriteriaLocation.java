package ForYouShipment.Search;

import java.util.ArrayList;
import java.util.List;

import ForYouShipment.Models.ContainerMeasurements;


public class CriteriaLocation implements Criteria<ContainerMeasurements> {

    @Override
    public List<ContainerMeasurements> meetCriteria(List<ContainerMeasurements> Containers, String query) {
            List<ContainerMeasurements> Containers_location = new ArrayList<>();
            
            for (ContainerMeasurements c: Containers){
                if(c.getLocation().toString().toLowerCase().contains(query.toLowerCase()))
                    Containers_location.add(c);

            }
        return Containers_location;
    }
}

