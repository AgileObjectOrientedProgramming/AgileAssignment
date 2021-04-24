package ForYouShipment.Workers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ForYouShipment.Models.ContainerMeasurements;
import ForYouShipment.Models.JourneyInfo;
import ForYouShipment.Search.Criteria;
import ForYouShipment.Search.CriteriaJourney;
import ForYouShipment.Storage.ContainerStorage;

public class ContainerTracker {
	
    private ContainerTracker() {};

    /**  Tracking a container with the given information
    * from the logistic company and clients can have access to view the container status */
    public static void setMeasurements(Map<String,String> measurements, JourneyInfo journey) {
        

        Set<ContainerMeasurements> Containers = ContainerStorage.GetInstance().getContainers();

        Criteria<ContainerMeasurements> criteria = new CriteriaJourney();
        
        List<ContainerMeasurements> s = criteria.meetCriteria(new ArrayList<ContainerMeasurements>(Containers) ,
                                                                 journey.getId());
        
        ContainerMeasurements measurement = s.get(0);

        for (Map.Entry<String, String> entry : measurements.entrySet()) {
            measurement.setParameter(entry.getKey(), entry.getValue());
        }
    }
     
}
