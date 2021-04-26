package ForYouShipment.Storage;

import java.util.HashSet;
import java.util.Set;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.Container;
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

    /**
     * This static method adds new Containers in a given location
     * @param val       Number of new containers to add
     * @param location  Port where to add the containers
     */
    public static void addContainers(int val, Port location) {
        while (val-- > 0){
            ContainerMeasurements c = new ContainerMeasurements();
            c.setLocation(location);
            instance.Containers.add(c);
        }
    }

    /**
     * 
     * @return
     */
    public static int getFreeContainers(){
        int i = 0;
        for (Container c : instance.Containers){
            if (!(c.getJourney()==null)){
                i++;
            }
        }
        return i;
    }

    private static ContainerStorage instance = null;

    public static ContainerStorage GetInstance() {
        if (instance == null) {
            instance = new ContainerStorage();
            for (Port p: Port.class.getEnumConstants())
            ContainerStorage.addContainers(50, p);
        }
        return instance;
    }
}
