package ForYouShipment.Models;

import ForYouShipment.Constants.Port;
import ForYouShipment.Workers.IDGenerator;

public class Container {

    private Port location;
    private String id;
<<<<<<< HEAD
    private Journey journey;

	public Container() {
=======
    private JourneyInfo journey;
    
    
    public Container() {
>>>>>>> fbf1581bfeda85231d9aaec818dd87a88371f4a4
       setId(IDGenerator.GenerateID());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JourneyInfo getJourney() {
        return journey;
    }

    public void setJourney(JourneyInfo journey) {
        this.journey = journey;
    }

    public Port getLocation() {
        return location;
    }

    public void setLocation(Port location) {
        this.location = location;
    }

}
