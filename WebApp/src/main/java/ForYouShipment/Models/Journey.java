package ForYouShipment.Models;

import ForYouShipment.Constants.Port;

public class Journey {

    private String content_type, company, id, status;
    private Port origin, destination;
<<<<<<< HEAD
    private JourneyInfo info;
    private ContainerMeasurements measurement; // container measurement should be linked with journey

    public ContainerMeasurements getMeasurement() {
		return measurement;
	}

	public void setMeasurement(ContainerMeasurements measurement) {
		this.measurement = measurement;
	}

	public Journey() {
        this.setStatus("Active");
        this.setId(IDGenerator.GenerateID());
        JourneyStorage.GetInstance().getJourneys().add(this);
    }
    
=======


>>>>>>> fbf1581bfeda85231d9aaec818dd87a88371f4a4
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrigin(Port origin) {
        this.origin = origin;
    }

    public void setDestination(Port destination) {
        this.destination = destination;
    }

    public Port getOrigin() {
        return origin;
    }

    public Port getDestination() {
        return destination;
    }


    
}
