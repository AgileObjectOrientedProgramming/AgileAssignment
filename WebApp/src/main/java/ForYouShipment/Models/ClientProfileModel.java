package ForYouShipment.Models;

import java.util.Arrays;
import java.util.List;

public class ClientProfileModel extends UserProfileModel {
    private static List<String> AvailableParameters = Arrays.asList("FirstName", "LastName", "Email", "CompanyName");
    
    @Override
    public List<String> getAllParameters() {
        return AvailableParameters;
    }

}
