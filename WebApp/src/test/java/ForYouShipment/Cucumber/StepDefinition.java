package ForYouShipment.Cucumber;
 
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
 
import ForYouShipment.ClientSearch.CriteriaUsername;
import ForYouShipment.Controllers.SignupController;
import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.LogisticsProfileModel;
import ForYouShipment.Models.LogisticsUserModel;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Models.UserProfileModel;
import ForYouShipment.Search.Criteria;
import ForYouShipment.Storage.UserStorage;
import ForYouShipment.WebApp.WebAppApplication;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
 
@SpringBootTest(classes = WebAppApplication.class)
@AutoConfigureMockMvc
public class StepDefinition {
    // @Autowired
    private MockMvc mockMvc;
 
    private UserProfileModel client;
    private String name;
    private UserModel logistic;
 
    @BeforeEach
    @Before
    public void SetUpUsers() {
        mockMvc = MockMvcBuilders.standaloneSetup(new SignupController()).build();
    }
 
    @After
    public void clearGarbage(){
        UserStorage.GetInstance().getUsers().clear();
    }
 
 
    @Given("a new client named {string}")
    public void a_new_client_named_(String name) {
        this.name = name;
        // assert(false);
    }
 
    @And("I am a logistic user")
    public void I_am_a_logistic_user(){
        UserModel a = new LogisticsUserModel();
        a.setID("1.2.3.4");
        a.setUsername("admin");
        a.setPassword("admin");
        UserProfileModel pa = new LogisticsProfileModel();
        for (String s : pa.getAllParameters()) {
            pa.setParameter(s, "test");
        }
        a.setProfile(pa);
        UserStorage.GetInstance().getUsers().add(a);
    }
 
 
    @Test
    @When("I create his profile")
    public void i_create_his_profile() throws Exception {
        UserModel a = new LogisticsUserModel();
        a.setID("1.2.3.4");
        a.setUsername("admin");
        a.setPassword("admin");
        UserProfileModel pa = new LogisticsProfileModel();
        for (String s : pa.getAllParameters()) {
            pa.setParameter(s, "test");
        }
        a.setProfile(pa);
        UserStorage.GetInstance().getUsers().add(a);
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.4");
 
        MvcResult resultActions = 
            this.mockMvc.perform(
                post("/Signup/CreateUser")
                .param("Username", "ola")
                .param("Password", "1234")
                .param("PasswordRetype", "1234")
                .session(session)
            )
            .andExpect(status().isOk())
            .andReturn();
    }
 
    @Then("storage has the client named {string}")
    public void storage_has_the_client_named(String name) {
        boolean b = false;
        Criteria<UserModel> criteria = new CriteriaUsername();
        List<UserModel> l = criteria.meetCriteria(new ArrayList<>(UserStorage.GetInstance().getUsers()), name);
        // assertTrue(l.size()==1);
    }
 
}