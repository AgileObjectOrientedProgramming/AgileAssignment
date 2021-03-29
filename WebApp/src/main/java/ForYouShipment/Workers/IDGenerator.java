package ForYouShipment.Workers;

import java.util.UUID;

public class IDGenerator {
    private IDGenerator() { }

    public static String GenerateID() {
        return UUID.randomUUID().toString();
    }
}
