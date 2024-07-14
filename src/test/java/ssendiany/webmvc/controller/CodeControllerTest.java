package ssendiany.webmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CodeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void deleteProduct() throws Exception {
    mockMvc.perform(
      delete("/product/12345")
    ).andExpectAll(
      status().isAccepted()
    );
  }
}
