package com.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mockMvc;

    private MockHttpSession session;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    ObjectMapper mapper;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        session = new MockHttpSession();
        User user =new User();
        user.setUsername("Dopa");
        user.setPasswd("ac3af72d9f95161a502fd326865c2f15");
        session.setAttribute("user", user);
    }



    @Test
    public void test() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/user/{userName}", "scott")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("scott"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    public void test1() throws Exception {
        User user = new User();
        user.setUsername("Dopa");
        user.setPasswd("ac3af72d9f95161a502fd326865c2f15");
        user.setStatus("1");

        String userJson = mapper.writeValueAsString(user);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(userJson.getBytes()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
