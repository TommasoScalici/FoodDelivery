package unipa.fooddelivery;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.web.context.*;

import unipa.fooddelivery.controllers.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebApplicationContext.class })
@WebAppConfiguration
public class IndexControllerTest {
 
    private MockMvc mockMvc;
 
    @Autowired
    private IndexController controllerMock;
 
    //The setUp() method is omitted.
 
    @Test
    public void indexShouldRenderHomePage() throws Exception {

        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(view().name("index"));

        verify(controllerMock, times(1)).index();
        verifyNoMoreInteractions(controllerMock);
    }
}