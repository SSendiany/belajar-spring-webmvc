package ssendiany.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void loginSuccess() throws Exception {
    mockMvc.perform(
        post(
            "/auth/login")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("username", "anto")
        .param("password", "rahasia")
    ).andExpectAll(
        status().isOk(),
        content().string(Matchers.containsString("OK")));
        cookie().value("username", Matchers.is("anto"));
    }
            
  @Test
  void loginFailed() throws Exception {
    mockMvc.perform(
      post("/auth/login")
      .contentType(MediaType.APPLICATION_FORM_URLENCODED)
      .param("username", "anto")
      .param("password", "salah")
    ).andExpectAll(
      status().isUnauthorized(),
      content().string(Matchers.containsString("KO")));
  }
}
