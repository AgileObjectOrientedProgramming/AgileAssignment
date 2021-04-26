package ForYouShipment.WebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ForYouShipment.Models.LogisticsProfileModel;
import ForYouShipment.Models.LogisticsUserModel;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Persistance.StoragePersistance;
import ForYouShipment.Storage.ContainerStorage;
import ForYouShipment.Storage.UserStorage;

@SpringBootApplication @ComponentScan(basePackages = { "ForYouShipment.Controllers" } )
public class WebAppApplication {

	static void InitialiseUsers() {
		UserModel admin = new LogisticsUserModel();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setID("0.0.0.0");
		admin.setProfile(new LogisticsProfileModel());
		admin.getProfile().setParameter("FirstName", "Administrator");
		admin.getProfile().setParameter("LastName", "Administrator");
		admin.getProfile().setParameter("Email", "admin@dtu.dk");
		admin.getProfile().setParameter("Role", "Admin");
		ContainerStorage.GetInstance();
		UserStorage.GetInstance().getUsers().add(admin);

	}
	public static void main(String[] args) {
		StoragePersistance.LoadStoragesFromDisk();
		InitialiseUsers();
		SpringApplication.run(WebAppApplication.class, args);
	}

}
