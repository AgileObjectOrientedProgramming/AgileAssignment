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

    /**
     * This method returns the number of Journeys to aprove
     * @return Number of Journeys waiting for aproval as int
     */
    public static int countJourneysToApprove(){
        int i = 0;
        for (JourneyInfo j : instance.Journeys){
            if (j.getStatus().contains("Waiting"))
                i++;
        }
        return i;
    }

    private static JourneyStorage instance = null;

    public static JourneyStorage GetInstance() {
        if (instance == null) {
            instance = new JourneyStorage();
        }
        return instance;
    }
}
