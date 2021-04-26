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
     * Gets the total number of containers
     * @return
     */
    public static int countContainers(){
        return instance.Containers.size();
    }

    /**
     * Gets the used containers (not in
     * a journey)
     * @return Used containers in a set
     */
    public static Set<ContainerMeasurements> getUsedContainers(){
        Set<ContainerMeasurements> used = new HashSet<>();
        for (ContainerMeasurements c : instance.Containers){
            if (c.getJourney()!=null){
                used.add(c);
            }
        }
        return used;
    }

        /**
     * Gets the number of free containers (not in
     * a journey)
     * @return Number of available container as int
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
