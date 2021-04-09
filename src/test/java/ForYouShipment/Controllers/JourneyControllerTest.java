package ForYouShipment.Controllers;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.only;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import ForYouShipment.Constants.Port;
import ForYouShipment.Models.ClientUserModel;
import ForYouShipment.Models.LogisticsUserModel;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Storage.ContainerStorage;
import ForYouShipment.Storage.UserStorage;
import ForYouShipment.WebApp.WebAppApplication;
import ForYouShipment.Models.Container;

// https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-normal-controllers/
// https://spring.io/guides/gs/testing-web/

@SpringBootTest(classes = WebAppApplication.class)
@AutoConfigureMockMvc
@SuppressWarnings("unchecked")
public class JourneyControllerTest {

    @Autowired
	private MockMvc mockMvc;
    
    @BeforeEach
    public void SetUpUsers() {
        UserModel a = new ClientUserModel();
        //UserModel b = new LogisticsUserModel();
        a.setID("1.2.3.4");
        a.setUsername("1234");
        a.setPassword("1234");
        // b.setID("1.2.3.5");
        // b.setUsername("1235");
        // b.setPassword("1234");
        UserStorage.GetInstance().getUsers().add(a);
        //UserStorage.GetInstance().getUsers().add(b);
    }

    @AfterEach
    public void ClearGarbage() {
        UserStorage.GetInstance().getUsers().clear();
    }

	@Test
	public void TestIndexAccess() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.4");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Journey/New")
                .session(session)
            )
            .andExpect(status().is(200))
            .andReturn();
        
            String view_name = resultActions.getModelAndView().getViewName();
        //    Map<String, Object> model = resultActions.getModelAndView().getModel();
       
            assertTrue(
                view_name.equals("Journey/New")
            );
    }

    @Test
	public void TestIndexnoAccess() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.5");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Journey/New")
                .session(session)
            )
            .andExpect(status().is(302))
            .andReturn();
        
            String view_name = resultActions.getModelAndView().getViewName();
        //    Map<String, Object> model = resultActions.getModelAndView().getModel();
            System.out.print(view_name);
            assertTrue(
                view_name.equals("redirect:/Login/")
            );
    }

    @Test
    public void TestRegisterContainer() throws Exception {

        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.4");

		MvcResult resultActions = 
            this.mockMvc.perform(
                post("/Journey/New")
                .param("Origin", "LISBON")
                .param("Destination", "PORTO")
                .param("Content type", "TESTTEST")
                .param("Company", "Coop")
                .session(session)
            )
            .andExpect(status().is(302))
            .andReturn();

        int i = 0;

        for (Container c: ContainerStorage.GetInstance().getContainers())
            if (c.getJourney() != null
                && c.getJourney().getContent_type().equals("TESTTEST"))
                    i++;
        
        assertTrue( i == 1);
    }

}