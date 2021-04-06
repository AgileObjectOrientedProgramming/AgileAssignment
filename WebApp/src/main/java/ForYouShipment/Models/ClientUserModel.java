package ForYouShipment.Models;

public class ClientUserModel extends UserModel {
    @Override
    public boolean HasAccessTo(String Path) {
        if (Path.equals("/Client") || Path.equals("/Client/") || Path.equals("/Client/Index") || 
                    Path.equals("/Client/View") || Path.equals("/Client/Index/") || Path.equals("/Client/View/")
                    || Path.equals("/Client/Edit/") || Path.equals("/Client/Edit"))
            return true;
        if (Path.equals("/"))
            return true;
        if (Path.startsWith("/Login"))
            return true;
        return false;
    }
    
    @Override
    public boolean IsLogisticUser() { return false; }
}
