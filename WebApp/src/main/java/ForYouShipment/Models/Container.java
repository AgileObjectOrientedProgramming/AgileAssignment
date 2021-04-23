package ForYouShipment.Models;

import java.util.List;
import java.util.Map;

import ForYouShipment.Constants.Port;
import ForYouShipment.Workers.IDGenerator;

public class Container {

    private Port location;
    private String id;
    private JourneyInfo journey;
    private List<Map<String,String>> measurementsHistory;
    
    public List<Map<String,String>> getMeasurementsHistory() {
        return measurementsHistory;
    }

    public void setMeasurementsHistory(List<Map<String,String>> measurementsHistory) {
        this.measurementsHistory = measurementsHistory;
    }

    public Container() {
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
