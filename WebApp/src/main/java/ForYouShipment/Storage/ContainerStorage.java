package ForYouShipment.Storage;

import java.util.HashSet;
import java.util.Set;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.ContainerMeasurements;

/**
 * Singleton class storing all informations.
 */
public class ContainerStorage{

    // Items to save.
    private Set <ContainerMeasurements> Containers;

    

    private ContainerStorage() {
        Containers = new HashSet<>();
    }

    public Set<ContainerMeasurements> getContainers() {
        return Containers;
    }

    public static void addContainers(ContainerStorage instance, int val, Port location) {
        while (val-- > 0){
            ContainerMeasurements c = new ContainerMeasurements();
            c.setLocation(location);
            ContainerStorage.GetInstance().getContainers().add(c);
        }
    }


    private static ContainerStorage instance = null;

    public static ContainerStorage GetInstance() {
        if (instance == null) {
            instance = new ContainerStorage();
            ContainerStorage.addContainers(instance, 200, Port.LISBON);
        }
        return instance;
    }
}
