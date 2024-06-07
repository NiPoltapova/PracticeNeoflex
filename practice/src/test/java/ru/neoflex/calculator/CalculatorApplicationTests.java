package ru.neoflex.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorApplicationTests {

    @Autowired
    private MockMvc mockMvc; // injected with @AutoConfigureMockMvc
    @Test
    /*void contextLoads() {
    }*/
    public void shouldReturnOurText1() throws Exception {
        this.mockMvc
                .perform(get("/plus/120/44"))
                .andDo(print())
                .andExpect(content().string(containsString("164")));
    }
    @Test
    public void shouldReturnOurText2() throws Exception {
        this.mockMvc
                .perform(get("/minus/100/8"))
                .andDo(print())
                .andExpect(content().string(containsString("92")));
    }
}
