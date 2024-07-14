package ssendiany.webmvc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DateController {
  
  private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

  @GetMapping(path = "/date")
  @ResponseBody
  public String getDate(@RequestParam(name = "date") Date date) throws IOException {
    return "Date : " + dateFormat.format(date);
  }
}
