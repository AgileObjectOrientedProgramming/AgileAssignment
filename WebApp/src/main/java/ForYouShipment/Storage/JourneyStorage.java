package ForYouShipment.Storage;

import java.util.HashSet;
import java.util.Set;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.Container;
import ForYouShipment.Models.Journey;

/**
 * Singleton class storing all informations.
 */
public class JourneyStorage implements Storage {

    // Items to save.
    private Set <Journey> Journeys;

    

    private JourneyStorage() {
        Journeys = new HashSet<>();
    }

    public Set<Journey> getJourneys() {
        return Journeys;
    }



    private static JourneyStorage instance = null;

    public static JourneyStorage GetInstance() {
        if (instance == null) {
            instance = new JourneyStorage();
        }
        return instance;
    }
}
