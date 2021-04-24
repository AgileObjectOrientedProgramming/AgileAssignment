package ForYouShipment.Constants;

public enum Port {

    LISBON("Lisbon"),
    PORTO("Porto"),
    AMSTERDAM("Amsterdam"),
    NEW_YORK("New York"), 
    RIO_DE_JANEIRO("Rio de Janeiro"), 
    CAPETOWN("Capetown"), 
    SHANGAI("Shangai"), 
    SYDNEY("Sydney"), 
    COPENHAGEN("Copenhagen");

    private final String name;

    Port(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public Double getLatitude(){
        Double lat = 0.0;
        switch (this) {
            case AMSTERDAM:
                lat = 52.412;
                break;
            case CAPETOWN:
                lat = -33.9043;
                break;
            case COPENHAGEN:
                lat = 55.6718;
                break;
            case LISBON:
                lat = 38.7020;
                break;
            case NEW_YORK:
                lat = 40.6677;
                break;
            case PORTO:
                lat = 41.1830 ;
                break;
            case RIO_DE_JANEIRO:
                lat = -22.8981;
                break;
            case SHANGAI:
                lat = 31.2198;
                break;
            case SYDNEY:
                lat = -33.8462;
                break;
       }
       return lat;
    }

    public Double getLongitude(){
        Double lng = 0.0;
        switch (this) {
            case AMSTERDAM:
                lng = 4.8079;
                break;
            case CAPETOWN:
                lng = 18.4301;
                break;
            case COPENHAGEN:
                lng = 12.5817;
                break;
            case LISBON:
                lng = -9.1734;
                break;
            case NEW_YORK:
                lng = -74.0407;
                break;
            case PORTO:
                lng = -8.7000;
                break;
            case RIO_DE_JANEIRO:
                lng = -43.1808;
                break;
            case SHANGAI:
                lng = 121.4870;
                break;
            case SYDNEY:
                lng = 151.2489;
                break;
       }
       return lng;        
    }
}
