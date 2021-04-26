package ForYouShipment;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.ui.Model;

import ForYouShipment.Facade.SignupFacade;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Models.UserProfileModel;
import ForYouShipment.Storage.UserStorage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@AutoConfigureMockMvc
public class StepDefinition {
    private UserProfileModel client;
    private String name;
    private UserModel logistic;

    @Autowired
	private MockMvc mockMvc;
    
    @Given("a new client named Emma")
    public void a_new_client_named_() {
        name = "Emma";
    }

    @When("I create his profile")
    public void i_create_his_profile() throws Exception {
        
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.4");

		MvcResult resultActions = 
            this.mockMvc.perform(
                post("/Signup/Index")
                .session(session)
            )
            .andExpect(status().isOk())
            .andReturn();

        
        Map<String, Object> model = resultActions.getModelAndView().getModel();
    
        SignupFacade.createUser((HttpServletRequest)resultActions.getRequest(), (Model)model, session, "Tonymontana", "1234", "1234");
    }
    
    @Then("storage has the client named Emma")
    public void storage_has_the_client_named() {
        boolean b = false;
        for (UserModel u : UserStorage.GetInstance().getUsers()){
            if (u.getUsername().equals("Tonymontana"))
                b = true;
        }
        assertTrue(b);
    }
    
    @Then("can perform CRUD operations")
    public void can_perform_CRUD_operations() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("a new client ID is generated")
    public void a_new_client_ID_is_generated() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("the ID is unique")
    public void the_ID_is_unique() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Given("a client")
    public void a_client() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @When("trying to access")
    public void trying_to_access() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("client can perform CRUD operations")
    public void client_can_perform_CRUD_operations() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    
    @Given("a database")
    public void a_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @When("input a client ID")
    public void input_a_client_ID() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("output a client")
    public void output_a_client() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Given("a user of a type")
    public void a_user_of_a_type() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @When("the login is successfull")
    public void the_login_is_successfull() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("access the permission level of type")
    public void access_the_permission_level_of_type() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
}