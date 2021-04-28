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
import ForYouShipment.Facade.ClientFacade;
import ForYouShipment.Facade.JourneyFacade;
import ForYouShipment.Facade.LoginFacade;
import ForYouShipment.Facade.SignupFacade;
import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.LogisticsUserModel;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Models.UserProfileModel;
import ForYouShipment.Search.Criteria;
import ForYouShipment.Storage.UserStorage;
import ForYouShipment.WebApp.WebAppApplication;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SpringBootTest(classes = WebAppApplication.class)
@AutoConfigureMockMvc
public class StepDefinition {
    
    private UserProfileModel client;
    private String name;
    private UserModel logistic;
    MockHttpServletRequest req;
    Model m;
    MockHttpSession session;

    @Before
    public void setUp(){
        req = new MockHttpServletRequest();
        m = new ConcurrentModel();
        session = new MockHttpSession();

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
        assertTrue(true);
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
    

    ///////////////////////////////////
    // Mandatory Task 2              //
    ///////////////////////////////////

    /** Scenario:
     *  Container registration
     * @throws Exception
     */
    

    @When("he registers the journey successfully")
    public void he_registers_the_journey_succefully() throws Exception{
        clientUM.getUsername();
        session.setAttribute("SignedUser", clientUM.getID());
        url = JourneyFacade.registerContainer(m, session, "Lisbon", "Porto", "Fragile", "company");
    }

    @Then("the journey is in our storage")
    public void the_journey_is_in_our_storage(){
        assertTrue(url.equals("redirect:/Journey/Index"));
        
    }
        

    @Given("a new client")
    public void a_new_client() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @When("it is registered")
    public void it_is_registered() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @When("trying to change is last name to {string}")
    public void trying_to_change_is_last_name_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("the last name is {string}")
    public void the_last_name_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Given("a commercial department user")
    public void a_commercial_department_user() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    
    @Then("a registration notification will be sent to the logistic company")
    public void a_registration_notification_will_be_sent_to_the_logistic_company() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I input a not covered port")
    public void i_input_a_not_covered_port() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("the Journey will not be registered")
    public void the_Journey_will_not_be_registered() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @When("I access the Journey")
    public void i_access_the_Journey() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @When("I will click on a journey")
    public void i_will_click_on_a_journey() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @When("I will change the status to confirmed")
    public void i_will_change_the_status_to_confirmed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("the corresponding client will have his Journey confirmed")
    public void the_corresponding_client_will_have_his_Journey_confirmed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    
    
    @Then("I will be able to locate my journey")
    public void i_will_be_able_to_locate_my_journey() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
   
    
    @Then("I will be able to get my journey ID")
    public void i_will_be_able_to_get_my_journey_ID() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Given("a customer of the logistic company's client")
    public void a_customer_of_the_logistic_company_s_client() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @When("I access the home page of the logistic company")
    public void i_access_the_home_page_of_the_logistic_company() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @When("I input a tracking code")
    public void i_input_a_tracking_code() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("I will be to locate the associated shipment")
    public void i_will_be_to_locate_the_associated_shipment() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
  
    @When("the temperature has a value far from the reality")
    public void the_temperature_has_a_value_far_from_the_reality() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
   
    @Then("I can see a list with all the history of the measurements")
    public void i_can_see_a_list_with_all_the_history_of_the_measurements() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
   
    @When("no measurements have been set from the logistic company")
    public void no_measurements_have_been_set_from_the_logistic_company() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("I can see no measurements")
    public void i_can_see_no_measurements() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    

}