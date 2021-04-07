package ForYouShipment.Storage;

import java.util.HashSet;
import java.util.Set;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.Container;

/**
 * Singleton class storing all informations.
 */
public class ContainerStorage implements Storage {

    // Items to save.
    private Set <Container> Containers;

    

    private ContainerStorage() {
        Containers = new HashSet<>();
    }

    public Set<Container> getContainers() {
        return Containers;
    }

    public void setContainers(Set<Container> containers) {
        Containers = containers;
    }

    public static void addContainers(ContainerStorage instance, int val, Port location) {
        while (val-- > 0){
            Container c = new Container();
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
