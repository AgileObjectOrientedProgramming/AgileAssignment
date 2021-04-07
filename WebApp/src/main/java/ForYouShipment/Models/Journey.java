package ForYouShipment.Models;

import ForYouShipment.Constants.Port;

public class Journey extends Container {

    private String content_type, company, id;

    private Port origin, destination;


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
