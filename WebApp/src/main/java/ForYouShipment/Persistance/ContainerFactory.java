package ForYouShipment.Persistance;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.ContainerMeasurements;
import ForYouShipment.Models.JourneyInfo;
import ForYouShipment.Search.Criteria;
import ForYouShipment.Search.CriteriaJID;
import ForYouShipment.Storage.JourneyStorage;

public class ContainerFactory {
    public static JSONObject ContainerToJSON(ContainerMeasurements container) {
        JSONObject obj = new JSONObject();
        obj.put("location", container.getLocation());
        obj.put("id", container.getId());
        if (container.getJourney()==null){
            return obj;
        }
        obj.put("journeyId", container.getJourney().getId());
        int i = 0;
        for (Map<String, String> measurement : container.getMeasurementsHistory()){
            final int i2 = i;
            measurement.forEach(((k,v) -> obj.put(k + i2, v)));
            i++;
        }
        obj.put("HistorySize", i);
        return obj;
    }

    public static ContainerMeasurements ContainerFromJSON(JSONObject obj){
        ContainerMeasurements c = new ContainerMeasurements();
        c.setId(obj.getString("id"));
        try {
            c.setLocation(Port.ofString(obj.getString("location")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Criteria<JourneyInfo> m = new CriteriaJID();
        JourneyInfo j = m.meetCriteria(new ArrayList<JourneyInfo>(JourneyStorage.GetInstance().getJourneys()),
                        obj.getString("journeyID")).get(0);
        c.setJourney(j);
        c.setAvailableParameters(Arrays.asList("Latitude","Longitude","Temperature", "Humidity","Pressure","Time"));
        c.setMeasurementsHistory(JSONtoHistory(obj));
        return c;
    }


    private static List<Map<String,String>> JSONtoHistory(JSONObject obj){
        List<Map<String,String>> measurementsHistory = new ArrayList<>();
        for  (int i = 0; i < Integer.valueOf(obj.getString("HistorySize")); i++){
            Map<String,String> m = new HashMap<>();
            m.put("Temperature", obj.getString("Temperature" + i));
            m.put("Pressure", obj.getString("Pressure" + i));
            m.put("Latitude", obj.getString("Latitude" + i));
            m.put("Longitude", obj.getString("Longitude" + i));
            m.put("Humidity", obj.getString("Humidity" + i));
            m.put("Time", obj.getString("Time" + i));
            measurementsHistory.add(m);
        } 
        return measurementsHistory;
    }
}
