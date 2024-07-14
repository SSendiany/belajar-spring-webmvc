package ssendiany.webmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class CodeController {

  @DeleteMapping(path = "/product/{Id}")
  @ResponseBody
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void delete(@PathVariable("Id") Integer id) {
    // delete from database
  }
}
