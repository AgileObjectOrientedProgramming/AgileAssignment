package ForYouShipment.Storage;

import java.util.HashSet;
import java.util.Set;

<<<<<<< HEAD
import ForYouShipment.Constants.Port;
import ForYouShipment.Models.Container;
=======
>>>>>>> c61d9a60be0905200c5b29dda2b25bce460fd5b5
import ForYouShipment.Models.Journey;

/**
 * Singleton class storing all informations.
 */
<<<<<<< HEAD
public class JourneyStorage implements Storage {
=======
public class JourneyStorage  {
>>>>>>> c61d9a60be0905200c5b29dda2b25bce460fd5b5

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
