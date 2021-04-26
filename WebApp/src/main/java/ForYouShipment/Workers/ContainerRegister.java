package ForYouShipment.Workers;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.Container;
import ForYouShipment.Models.ContainerMeasurements;
import ForYouShipment.Models.JourneyInfo;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Storage.ContainerStorage;

public class ContainerRegister {
    
    private ContainerRegister() {};

    /**  This method searches for an available container
    * and sets a JourneyInfo for it
    * @param  origin         A string with the name of the origin
    * @param destination    A string with the name of the destination
    * @param content_type   A string with the name of the content_type
    * @param company        A string with the name of the company
    * @param user           The user's UserModel
    * @return container
     * @throws Exception
    */
    public static ContainerMeasurements setJourney(String origin,
                                    String destination,
                                    String content_type,
                                    String company,
                                    UserModel user) throws Exception {

                              
        ContainerMeasurements container = ContainerRegister.getFreeContainer(Port.ofString(origin));             
        JourneyInfo journey = new JourneyInfo();
        journey.setOrigin(Port.ofString(origin));
        journey.setDestination(Port.ofString(destination));
        journey.setContent_type(content_type);
        journey.setCompany(company);
        journey.setParameter("Username", user.getUsername());
        journey.setParameter("ID", user.getID());
        
        container.setJourney(journey);
        container.setParameter("Latitude", "" + Port.ofString(origin).getLatitude());
        container.setParameter("Longitude","" + Port.ofString(origin).getLongitude());
        return container;
    }

    /**  Gets a random availabe container from the storage
     *   that is located at the given Port.
     */
    public static ContainerMeasurements getFreeContainer(Port origin) {
        for (ContainerMeasurements c: ContainerStorage.GetInstance().getContainers()) {
            if (c.getJourney() == null && c.getLocation() == origin)  
                return c;
                
        }
        return null;
    }

      /**  Using this method on a container completes the Journey.
       *  It sets the location of the container to the destination of the journey,
       *  marks the journey status as "Completed"
       *  and dissociates the container from the journey.
       * @param container Container to return
     */
    public static void returnContainer(ContainerMeasurements container) {
        Port destination = container.getJourney().getDestination();
        container.setParameter("Latitude", destination.getLatitude().toString());
        container.setParameter("Longitude", destination.getLongitude().toString());
        container.setLocation(container.getJourney().getDestination());
        container.getJourney().setStatus("Completed");
        container.setJourney(null);
    }
}

