package spitter.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spitter.Spittr;
import spitter.data.SpitterRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

//    @Test
//    public void shouldShowRegisterForm() throws Exception {
//        SpitterController spitterController = new SpitterController();
//        MockMvc mockMvc = standaloneSetup(spitterController).build();
//
//        mockMvc.perform(get("/spitter/register"))
//                .andExpect(view().name("registerForm"));
//    }


    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository =
                mock(SpitterRepository.class);

        Spittr unsaved = new Spittr("jbauer", "24hours", "Jack", "Bauer");
        Spittr saved = new Spittr("jbauer", "24hours", "Jack", "Bauer");

        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller =
                new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("userName", "jbauer")
                .param("password", "24hours"))
                .andExpect(redirectedUrl("/spitter/jbauer"));
        verify(mockRepository, atLeastOnce()).save(unsaved);
    }
}