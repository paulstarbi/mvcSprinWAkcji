package spitter.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spitter.Spittle;
import spitter.data.SpittleRepository;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpittleControllerTest {

    @Test
    public void testSplitte() throws Exception {
        Spittle expectedSplite = new Spittle("Hello", new Date());
        SpittleRepository repository = mock(SpittleRepository.class);
        when(repository.findOne(12345)).thenReturn(expectedSplite);

        SpittleController controller = new SpittleController(repository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSplite));
    }

}