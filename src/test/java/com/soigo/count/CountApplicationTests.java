package com.soigo.count;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class CountApplicationTests {
    final MockMvc mockMvc;

    @Autowired
    CountApplicationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void contextLoads() {
    }


    @Test
    public void testYourController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/swagger-ui/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
