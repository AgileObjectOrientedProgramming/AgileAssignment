package ForYouShipment.Workers;

import ForYouShipment.Models.Container;
import ForYouShipment.Models.ContainerMeasurements;

public class ContainerTracker {
	
    private ContainerTracker() {};
    private static Container container; // container should be a static field here

    /**  Tracking a container with the given information
    * from the logistic company and clients can have access to view the container status */
    public static Container setMeasurements(String temperature,
                                    String humidity,
                                    String pressure,
                                    Container container) {
        
    	ContainerTracker.container = container;
    	ContainerMeasurements measurement = new ContainerMeasurements();
        measurement.setTemperature(Double.parseDouble(temperature));
        measurement.setHumidity(Double.parseDouble(humidity));
        measurement.setPressure(Double.parseDouble(pressure));
        
       // container.setMeasurement(measurement);
        
        return container;
    }

	public static Container getContainer() {
		return container;
	}
     
}
