package ssendiany.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ssendiany.webmvc.service.HelloService;


@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerMockTest {
  
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private HelloService helloService;

  @BeforeEach
  void setUp() {
    Mockito.when(helloService.hello(Mockito.anyString()))
        .thenReturn("Hello Guys");
  }


  @Test
  void helloName() throws Exception {
    mockMvc.perform(
        get("/hello").queryParam("name", "Anto")
      ).andExpectAll(
            status().isOk(),
            content().string(Matchers.containsString("Hello Guys")));
  }
  
}
