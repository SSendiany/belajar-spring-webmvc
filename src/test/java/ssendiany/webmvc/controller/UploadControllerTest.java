package ssendiany.webmvc.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UploadControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void uploadFile() throws Exception {
    mockMvc.perform(multipart("/upload/profile")
        .file(new MockMultipartFile("profile", "profile.jpg", "image/jpg",
        getClass().getResourceAsStream("/images/DSC05316.jpg")))
        .contentType(MediaType.MULTIPART_FORM_DATA)
        .param("name", "Anto")
    ).andExpectAll(
        status().isOk(),
        content().string(Matchers.containsString("Success save profile Anto to upload\\profile.jpg"))
    );
  }

}
