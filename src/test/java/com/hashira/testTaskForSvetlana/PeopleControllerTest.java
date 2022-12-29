package com.hashira.testTaskForSvetlana;

import com.hashira.testTaskForSvetlana.controllers.PeopleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PeopleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PeopleController peopleController;

    @Test
    public void FirstUserTest() throws Exception{
        this.mockMvc.perform(get("/api/users/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{name : mock_name_1, surname : mock_surname_1, age : 32}"));;
    }

    @Test
    public void SecondUserTest() throws Exception{
        this.mockMvc.perform(get("/api/users/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{name : mock_name_2, surname : mock_surname_2, age : 19}"));;
    }

    @Test
    public void ThirdUserTest() throws Exception{
        this.mockMvc.perform(get("/api/users/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{name : mock_name_3, surname : mock_surname_3, age : 22}"));;
    }

    @Test
    public void specifiedUserDoNotExistTest() throws Exception{
        this.mockMvc.perform(get("/api/users/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{name : null, surname : null, age : null}"));;
    }
}
