package ssendiany.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {
  
  @Autowired
  private MockMvc mockMvc;

  @Test
  void helloGuest() throws Exception {
    mockMvc.perform(
        get("/hello")
      ).andExpectAll(
            status().isOk(),
            content().string(Matchers.containsString("Hello Guest")));
  }

  @Test
  void helloAnto() throws Exception {
    mockMvc.perform(
        get("/hello").queryParam("name", "Anto")).andExpectAll(
            status().isOk(),
            content().string(Matchers.containsString("Hello Anto")));
  }
  
  @Test
  void helloPost() throws Exception {
    mockMvc.perform(
      post("/hello").queryParam("name", "Anto")).andExpectAll(
          status().isMethodNotAllowed()
    );
  }
}
