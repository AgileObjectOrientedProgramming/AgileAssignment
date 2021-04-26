package ForYouShipment.Storage;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.ContainerMeasurements;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Persistance.ContainerFactory;
import ForYouShipment.Persistance.UserModelFactory;

/**
 * Singleton class storing all informations.
 */
public class ContainerStorage implements Storage{

    // Items to save.
    private Set <ContainerMeasurements> Containers;

    

    private ContainerStorage() {
        Containers = new HashSet<>();
    }

    public JSONArray SaveContentToJSON() {
        JSONArray array = new JSONArray();

        for (ContainerMeasurements c : Containers)
            array.put(ContainerFactory.ContainerToJSON(c));
        return array;
    }

    public void ReadContentFromJSON(JSONArray array) {
        Containers = new HashSet<>();

        // for (int i = 0; i < array.length(); i++) {
        //     JSONObject obj = array.getJSONObject(i);
        //     ContainerMeasurements u = UserModelFactory.UserModelFromJSON(obj);
        //     Containers.add(u);
        // }
    }

    public String StorageName() { 
        return "ContainerStorage"; 
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
            for (Port p: Port.class.getEnumConstants())
            ContainerStorage.addContainers(instance, 50, p);
        }
        return instance;
    }
}
