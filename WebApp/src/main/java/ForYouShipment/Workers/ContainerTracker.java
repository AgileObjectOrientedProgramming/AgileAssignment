package ForYouShipment.Workers;

import ForYouShipment.Models.ContainerMeasurements;
import ForYouShipment.Models.Journey;

public class ContainerTracker {
	
    private ContainerTracker() {};
    private static Journey journey; // journey should be a static field here

    /**  Tracking a container with the given information
    * from the logistic company and clients can have access to view the container status */
    public static Journey setMeasurements(String temperature,
                                    String humidity,
                                    String pressure,
                                    Journey journey) {
        
    	ContainerTracker.journey = journey;
    	ContainerMeasurements measurement = new ContainerMeasurements();
        measurement.setTemperature(Double.parseDouble(temperature));
        measurement.setHumidity(Double.parseDouble(humidity));
        measurement.setPressure(Double.parseDouble(pressure));
        
        journey.setMeasurement(measurement);
        
        return journey;
    }

	public static Journey getJourney() {
		return journey;
	}
     
}
