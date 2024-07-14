package ssendiany.webmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class AuthController {
  @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public ResponseEntity<String> login(
    @RequestParam(name = "username") String username,
    @RequestParam(name = "password") String password,
    HttpServletResponse servletResponse
  ) {
      
    if ("anto".equals(username) && "rahasia".equals(password)) {
        Cookie cookie = new Cookie("username", username);
        cookie.setPath("/");
        servletResponse.addCookie(cookie);

        return new ResponseEntity<>("OK", HttpStatus.OK);
      } else {
        return new ResponseEntity<>("KO", HttpStatus.UNAUTHORIZED);
      }
  }
  
}
