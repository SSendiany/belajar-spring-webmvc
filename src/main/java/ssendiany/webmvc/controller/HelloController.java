package ssendiany.webmvc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import ssendiany.webmvc.service.HelloService;

@Controller
public class HelloController {
  
  @Autowired
  private HelloService helloService;

  @GetMapping(path = "/hello")
  public void helloWorld(HttpServletResponse response, @RequestParam(name = "name", required = false) String name) throws IOException {
    String responseBody = helloService.hello(name);
    response.getWriter().println(responseBody);
  }
}
