package ForYouShipment.Storage;

import java.util.HashSet;
import java.util.Set;

import ForYouShipment.Models.JourneyInfo;

/**
 * Singleton class storing all informations.
 */
public class JourneyStorage  {

    // Items to save.
    private Set <JourneyInfo> Journeys;

    

    private JourneyStorage() {
        Journeys = new HashSet<>();
    }

    public Set<JourneyInfo> getJourneys() {
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
