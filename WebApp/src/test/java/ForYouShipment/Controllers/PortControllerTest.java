package ForYouShipment.Controllers;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Set;

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
import ForYouShipment.Models.LogisticsProfileModel;
import ForYouShipment.Models.LogisticsUserModel;
import ForYouShipment.Models.UserModel;
import ForYouShipment.Models.UserProfileModel;
import ForYouShipment.Storage.UserStorage;
import ForYouShipment.WebApp.WebAppApplication;

@SpringBootTest(classes = WebAppApplication.class)
@AutoConfigureMockMvc
@SuppressWarnings("unchecked")
public class PortControllerTest {

    @Autowired
	private MockMvc mockMvc;
    
    @BeforeEach
    public void SetUpUsers() {
        UserModel admin = new LogisticsUserModel();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setID("0.0.0.0");
		admin.setProfile(new LogisticsProfileModel());
		admin.getProfile().setParameter("First Name", "Administrator");
		admin.getProfile().setParameter("Last Name", "Administrator");
		admin.getProfile().setParameter("Email", "admin@dtu.dk");
		admin.getProfile().setParameter("Role", "Admin");
		UserStorage.GetInstance().getUsers().add(admin);
    }

    @AfterEach
    public void ClearGarbage() {
        UserStorage.GetInstance().getUsers().clear();
    }



    @Test
    public void ViewTest() throws Exception{
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("SignedUser", "0.0.0.0");

		MvcResult resultActions = 
            this.mockMvc.perform(
                get("/Port/View")
                .param("Port", "Lisbon")
            )
            .andExpect(status().is(302))
            .andReturn();
        
        String view_name = resultActions.getModelAndView().getViewName();       
        assertTrue(view_name.equals("redirect:/Login/")); 
    }



}
