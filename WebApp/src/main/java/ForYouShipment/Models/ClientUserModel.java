package ForYouShipment.Models;

public class ClientUserModel extends UserModel {
    @Override
    public boolean HasAccessTo(String Path) {
        if (Path.startsWith("/Client"))
            return true;
        if (Path.equals("/"))
            return true;
        if (Path.startsWith("/Login"))
            return true;
        return false;
    }
}
