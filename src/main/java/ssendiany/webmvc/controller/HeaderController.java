package ssendiany.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HeaderController {

  @GetMapping(path = "/header/token")
  @ResponseBody  
  public String header(@RequestHeader(name = "X-TOKEN") String token) {
    if ("ANTO".equals(token)) {
      return "OK";
    } else {
      return "KO";
    }
  }
}
