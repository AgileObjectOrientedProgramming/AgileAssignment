package ForYouShipment.Workers;

import java.util.UUID;

public class IDGenerator {
    private IDGenerator() { }

    public String GenerateID() {
        return UUID.randomUUID().toString();
    }

    private static IDGenerator instance = null;

    public static IDGenerator GetInstance() {
        if (instance == null) 
            instance = new IDGenerator();
        return instance;
    }
}
