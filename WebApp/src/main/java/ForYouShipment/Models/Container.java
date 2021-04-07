package ForYouShipment.Models;

import ForYouShipment.Constants.Port;
import ForYouShipment.Workers.IDGenerator;

public class Container {

    private Port location;
    private String id;
   
    /** Availability of the container 
     * True if the container is in the Storage
     * False if the container is in a Journey */ 
    private Journey journey;
   
    
    public Container() {
       setId(IDGenerator.GenerateID());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public Port getLocation() {
        return location;
    }

    public void setLocation(Port location) {
        this.location = location;
    }

  



}
