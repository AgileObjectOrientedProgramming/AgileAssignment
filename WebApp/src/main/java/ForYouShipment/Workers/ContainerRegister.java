package ForYouShipment.Workers;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.Container;
import ForYouShipment.Models.Journey;
import ForYouShipment.Models.JourneyInfo;
import ForYouShipment.Storage.ContainerStorage;

public class ContainerRegister {
    
    private ContainerRegister() {};

    /**  Registering a container with the given information
    * from the user for a Journey */
    public static Container setJourney(String origin,
                                    String destination,
                                    String content_type,
                                    String company,
                                    Container container,
                                    JourneyInfo info) {
                     
        Journey journey = new Journey();
        journey.setOrigin(Port.valueOf(origin.toUpperCase()));
        journey.setDestination(Port.valueOf(destination.toUpperCase()));
        journey.setContent_type(content_type);
        journey.setCompany(company);
        journey.setInfo(info);
        
        container.setJourney(journey);
        return container;
    }

    /**  Gets a random availabe container from the storage
     *   that is located at the given origin.
     */
    public static Container getFreeContainer(Port origin) {
        for (Container c: ContainerStorage.GetInstance().getContainers()) {
            if (c.getJourney() == null && c.getLocation() == origin)  
                return c;
                
        }
        return null;
    }

    public static void returnContainer(Container c) {
        c.setLocation(c.getJourney().getDestination());
        c.getJourney().setStatus("Completed");
        c.setJourney(null);
    }


}

