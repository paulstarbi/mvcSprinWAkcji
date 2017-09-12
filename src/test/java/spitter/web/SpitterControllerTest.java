package spitter.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
}