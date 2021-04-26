package ForYouShipment.Persistance;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.json.*;

import ForYouShipment.Models.ClientProfileModel;
import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.ContainerMeasurements;
import ForYouShipment.Models.LogisticsProfileModel;
import ForYouShipment.Models.LogisticsUserModel;
import ForYouShipment.Models.UserModel;

public class ContainerFactory {
    public static JSONObject ContainerToJSON(ContainerMeasurements container) {
        JSONObject obj = new JSONObject();
        obj.put("location", container.getLocation());
        obj.put("id", container.getId());
        for (String item : container.getAllParameters())
            obj.put(item, container.getParameter(item));
        return obj;
    }

    public static UserModel UserModelFromJSON(JSONObject obj) throws JSONException {
        ContainerMeasurements c = null;

     
        
        c.setID(obj.getString("ID"));
        c.setUsername(obj.getString("Username"));
        char.setPassword(obj.getString("Password"));
        
        for (String item : c.getProfile().getAllParameters())
            user.getProfile().setParameter(item, obj.getString(item));

        return user;
    }
}
