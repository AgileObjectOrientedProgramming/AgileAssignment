package ForYouShipment.Controllers;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import ForYouShipment.Models.Container;
import ForYouShipment.Models.LogisticsUserModel;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Storage.ContainerStorage;
import ForYouShipment.Storage.JourneyStorage;
import ForYouShipment.Storage.UserStorage;
import ForYouShipment.WebApp.WebAppApplication;

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
        UserModel client = new ClientUserModel();
        client.setID("1.2.3.4");
        client.setUsername("1234");
        client.setPassword("1234");
        UserModel logisticUser = new LogisticsUserModel();
        logisticUser.setID("1.2.3.1");
        logisticUser.setUsername("1231");
        logisticUser.setPassword("1231");
        UserStorage.GetInstance().getUsers().add(client);
        UserStorage.GetInstance().getUsers().add(logisticUser);     
    }

    @AfterEach
    public void ClearGarbage() {
        UserStorage.GetInstance().getUsers().clear();
        JourneyStorage.GetInstance().getJourneys().clear();
        
    }

	@Test
	public void TestNewAccess() throws Exception {
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
       
            assertTrue(
                view_name.equals("Journey/New")
            );
    }

    @Test
	public void TestNewnoAccess() throws Exception {
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

    @Test
    public void TestSearchNoAccess() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.5");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Journey/Search")
                .session(session)
            )
            .andExpect(status().is(302))
            .andReturn();
        
        String view_name = resultActions.getModelAndView().getViewName();
        System.out.print(view_name);
        assertTrue(
            view_name.equals("redirect:/Login/")
        );
    }
    

    @Test
    public void TestSearchAccess() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.4");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Journey/Search")
                .session(session)
            )
            .andExpect(status().isOk())
            .andReturn();
        
        String view_name = resultActions.getModelAndView().getViewName();
        System.out.print(view_name);
        assertTrue(
            view_name.equals("Journey/Search")
        );
            
    }

    @Test
    public void TestSearchLogisticAccess() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.1");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Journey/Search")
                .session(session)
            )
            .andExpect(status().isOk())
            .andReturn();
        
        String view_name = resultActions.getModelAndView().getViewName();
        assertTrue(
            view_name.equals("Journey/Search")
        );
    }


    //FIXME
    // @Test
    // public void TestSearchNullQuery() throws Exception {
    //     MockHttpSession session = new MockHttpSession();
    //     session.setAttribute("SignedUser", "1.2.3.1");
        
	// 	MvcResult resultActions = 
    //         this.mockMvc.perform(
    //             get("/Journey/Search")
    //             .requestAttr("Query", (String)null)
    //             .session(session)
    //         )
    //         .andExpect(status().isOk())
    //         .andReturn();
        
    //     String view_name = resultActions.getModelAndView().getViewName();
        
    //     assertTrue(
    //         view_name.equals("Journey/Search")
    //     );
    // }



    @Test
    public void TestIndexAccess() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.4");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Journey/Index")
                .session(session)
            )
            .andExpect(status().isOk())
            .andReturn();
        
        String view_name = resultActions.getModelAndView().getViewName();
        System.out.print(view_name);
        assertTrue(
            view_name.equals("Journey/Index")
        );
    }

    @Test
    public void TestIndexNoAccess() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "1.2.3.1");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Journey/Index")
                .session(session)
            )
            .andExpect(status().is(302))
            .andReturn();
        
        String view_name = resultActions.getModelAndView().getViewName();
        System.out.print(view_name);
        assertTrue(
            view_name.equals("redirect:/Login/")
        );
    }
}