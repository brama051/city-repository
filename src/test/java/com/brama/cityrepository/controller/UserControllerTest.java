package com.brama.cityrepository.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    
	@Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnBadRequest() throws Exception {
        this.mockMvc.perform(post("/register")).andExpect(status().isBadRequest());
    }
    
    @Test
    public void shouldUnprocessable() throws Exception {
        this.mockMvc.perform(post("/register")
        		.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        		.content("email=test&password=somepassword"))
        .andExpect(status().isUnprocessableEntity());
    }
    
    @Test
    public void shouldFailLogin() throws Exception {
        this.mockMvc.perform(post("/login")
        		.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        		.content("email=test&password=badpassword"))
        .andExpect(status().isUnauthorized());
    }
    
    @Test
    public void shouldFailWithUnprocessable() throws Exception {
        this.mockMvc.perform(post("/register")).andExpect(status().isBadRequest());
    }
    
}
