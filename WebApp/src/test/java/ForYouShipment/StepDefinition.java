package ForYouShipment;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import ForYouShipment.ClientSearch.CriteriaUsername;
import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.LogisticsUserModel;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Models.UserProfileModel;
import ForYouShipment.RefactoredControllers.ClientFacade;
import ForYouShipment.RefactoredControllers.LoginFacade;
import ForYouShipment.RefactoredControllers.SignupFacade;
import ForYouShipment.Search.Criteria;
import ForYouShipment.Storage.UserStorage;
import ForYouShipment.WebApp.WebAppApplication;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SpringBootTest(classes = WebAppApplication.class)
@AutoConfigureMockMvc
public class StepDefinition {
    
    private UserProfileModel client;
    private String name;
    private UserModel logistic;
    
    @BeforeEach
    public void SetUpUsers() {
        
    }

    @After
    public void clearGarbage(){
        UserStorage.GetInstance().getUsers().clear();
    }

    @Autowired
	protected MockMvc mockMvc;
    
    @Given("a new client named {string}")
    public void a_new_client_named_(String name) {
        this.name = name;
    }

    @When("I create his profile")
    public void i_create_his_profile() throws Exception {
        UserModel a = new LogisticsUserModel();
        a.setID("1.2.3.4");
        a.setUsername("1234");
        a.setPassword("1234");
        

        UserStorage.GetInstance().getUsers().add(a);
        MockHttpServletRequest req = new MockHttpServletRequest();
        Model m = new ConcurrentModel();
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.4");
        SignupFacade.createUser(req, m, session, name, "1234", "1234");
    }
    
    @Then("storage has the client named {string}")
    public void storage_has_the_client_named(String name) {
        boolean b = false;
        for (UserModel u : UserStorage.GetInstance().getUsers()){
            if (u.getUsername().equals(name))
                b = true;
        }
        assertTrue(b);
    }

    
    //UserStory 1 ///////////////////////////////////////
    //Scenario : Client login
    private UserModel clientUM;
    MockHttpSession session;
    @Given("a client account")
    public void a_client_account(){
        clientUM = new ClientUserModel();
        clientUM.setID("1.2.3.4");
        clientUM.setUsername("1234");
        clientUM.setPassword("1234");
        UserStorage.GetInstance().getUsers().add(clientUM);
    }
    
    @When("the client tries to login")
    public void the_client_tries_to_login(){
        MockHttpServletRequest req = new MockHttpServletRequest();
        Model m = new ConcurrentModel();
        session = new MockHttpSession();
        LoginFacade.Login(m, session, "1234", "1234");
    }

    @Then("he is logged in his account") //Shared with next scenario
    public void he_is_logged_in_his_account(){
        assertTrue(
            session
            .getAttribute("SignedUser")
            .equals("1.2.3.4")
        );
    }


    ///////////////////////////////////////////
    //Scenario Outline: Logistic user login  //
    ///////////////////////////////////////////
    UserModel logisticUM;
    @Given("a logistic account")
    public void a_logistic_account(){
        logisticUM = new LogisticsUserModel();
        logisticUM.setID("1.2.3.4");
        logisticUM.setUsername("1234");
        logisticUM.setPassword("1234");
        UserStorage.GetInstance().getUsers().add(logisticUM);
    }
    
    @When("the logistic user tries to login")
    public void the_logistic_user_tries_to_login(){
        MockHttpServletRequest req = new MockHttpServletRequest();
        Model m = new ConcurrentModel();
        session = new MockHttpSession();
        LoginFacade.Login(m, session, "1234", "1234");
    }


    ///////////////////////////////////////////
    //Scenario Outline: Failed login         //
    ///////////////////////////////////////////
    UserModel user;
    String url;
    @Given("a web user")
    public void a_web_user(){
        user = null;
    }

    @When("he tries to login with wrong credencials")
    public void he_tries_to_login_with_wrong_crendencials(){
        Model m = new ConcurrentModel();
        session = new MockHttpSession();
        url = LoginFacade.Login(m, session, "1234", "1234");
    }
    
    @Then("the login is unsuccessful")
    public void the_login_is_unsuccessful() {
        assertTrue(url.equals("Login/Index"));
    }

    ///////////////////////////////////////////
    //Scenario Outline: Deleting a client    //
    ///////////////////////////////////////////
    String ID;
    @When("he deletes the client")
    public void he_deletes_a_customer(){
        MockHttpServletRequest req = new MockHttpServletRequest();
        ID = clientUM.getID();
        ClientFacade.Delete(req, session, ID);
    }

    @Then("the customer is no longer in the storage")
    public void the_customer_is_no_longer_in_the_storage(){
        Criteria<UserModel> critera = new CriteriaUsername();
        List<UserModel> l = critera.meetCriteria(new ArrayList<>(UserStorage.GetInstance().getUsers()), ID);
        assertTrue(l.size()==1);
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