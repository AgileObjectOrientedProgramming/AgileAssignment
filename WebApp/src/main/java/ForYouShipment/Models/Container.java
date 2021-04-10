package ForYouShipment.Models;

import ForYouShipment.Constants.Port;
import ForYouShipment.Workers.IDGenerator;

public class Container {

    private Port location;
    private String id;
    private Journey journey;
<<<<<<< HEAD
=======
    
>>>>>>> c61d9a60be0905200c5b29dda2b25bce460fd5b5
    
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
