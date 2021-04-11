package ForYouShipment.Controllers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.LogisticsUserModel;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Storage.UserStorage;
import ForYouShipment.WebApp.WebAppApplication;

// https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-normal-controllers/
// https://spring.io/guides/gs/testing-web/

@SpringBootTest(classes = WebAppApplication.class)
@AutoConfigureMockMvc
@SuppressWarnings("unchecked")
public class ClientControllerTest {

    @Autowired
	private MockMvc mockMvc;
    
    @BeforeEach
    public void SetUpUsers() {
        UserModel a = new LogisticsUserModel();
        a.setID("1.2.3.4");
        a.setUsername("1234");
        a.setPassword("1234");
        UserStorage.GetInstance().getUsers().add(a);

        a = new ClientUserModel();
        a.setID("1.1.1.1");
        a.setUsername("abcd");
        a.setPassword("abcd");
        UserStorage.GetInstance().getUsers().add(a);
    }

    @AfterEach
    public void ClearGarbage() {
        UserStorage.GetInstance().getUsers().clear();
    }

	@Test
	public void TestUnSuccessfulClientsPage() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.0");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Client/Index")
            )
            .andExpect(status().is(302))
            .andReturn();

        String view_name = resultActions.getModelAndView().getViewName();
        assertTrue(view_name.equals("redirect:/Login/"));
    }

    @Test
	public void TestSuccessfulClientPage() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.1.1.1");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Client/Index")
                .session(session)
            )
            .andExpect(status().isOk())
            .andReturn();
        
        
        String view_name = resultActions.getModelAndView().getViewName();
        Map<String, Object> model = resultActions.getModelAndView().getModel();

        UserModel SignedUser = (UserModel)model.get("SignedUser");

        assertTrue(
            SignedUser
            .getUsername()
            .equals("abcd")
        );  
        assertTrue(view_name.equals("Client/Index"));
    }

    @Test
	public void TestUnSuccessfulViewPage() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.4");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Client/Index")
            )
            .andExpect(status().is(302))
            .andReturn();
    }

    @Test
	public void TestSuccessfulViewPage() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.1.1.1");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Client/View")
                .param("ID", "1.1.1.1")
                .session(session)
            )
            .andExpect(status().isOk())
            .andReturn();
        
        
        
        String view_name = resultActions.getModelAndView().getViewName();
        Map<String, Object> model = resultActions.getModelAndView().getModel();

        UserModel SignedUser = (UserModel)model.get("SignedUser");
        UserModel ProfileUser = (UserModel)model.get("ProfileUser");

        assertTrue(
            SignedUser
            .getUsername()
            .equals("abcd")
        );  

        assertTrue(
            ProfileUser
            .getID()
            .equals("1.1.1.1")
        );  

        assertTrue(view_name.equals("Client/View"));
    }

    @Test
	public void TestSuccessfulSearchPage() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.4");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Client/Search")
                .session(session)
            )
            .andExpect(status().isOk())
            .andReturn();

        String view_name = resultActions.getModelAndView().getViewName();
        assertTrue(view_name.equals("Client/Search"));
    }

    @Test
	public void TestUnSuccessfulSearchPage() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.1.1.1");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Client/Search")
                .session(session)
            )
            .andExpect(status().is(302))
            .andReturn();

            String view_name = resultActions.getModelAndView().getViewName();
            assertTrue(view_name.equals("redirect:/Login/"));
    
    }

    @Test
	public void TestSuccessfulDeletePage() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.4");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Client/Delete")
                .session(session)
                .param("ID", "test")
            )
            .andExpect(status().is(302))
            .andReturn();

        String view_name = resultActions.getModelAndView().getViewName();
        assertTrue(view_name.equals("redirect:/Logistics"));
    }

    @Test
	public void TestUnSuccessfulDeletePage() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.1.1.1");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Client/Delete")
                .session(session)
                .param("ID", "test")
            )
            .andExpect(status().is(302))
            .andReturn();

            String view_name = resultActions.getModelAndView().getViewName();
            assertTrue(view_name.equals("redirect:/Login/"));
    
    }
}