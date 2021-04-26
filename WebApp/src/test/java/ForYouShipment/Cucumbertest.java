package ForYouShipment;

import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import ForYouShipment.Storage.UserStorage;
import ForYouShipment.WebApp.WebAppApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SpringBootTest(classes = WebAppApplication.class)
@AutoConfigureMockMvc
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/main/resources")
public class Cucumbertest {

   
}