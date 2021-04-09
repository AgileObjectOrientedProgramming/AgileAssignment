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

}
