package ForYouShipment.Search;

import java.util.ArrayList;
import java.util.List;

import ForYouShipment.Models.ContainerMeasurements;


public class CriteriaJourney implements Criteria<ContainerMeasurements> {

    @Override
    public List<ContainerMeasurements> meetCriteria(List<ContainerMeasurements> list, String query) {
        List<ContainerMeasurements> answer = new ArrayList<ContainerMeasurements>();
        for (ContainerMeasurements c : list){
            if (c.getJourney().getId().equals(query)){
                answer.add(c);
                return answer;
            }
        }

        return null; //TODO Create our own exception 
    }
    
}
