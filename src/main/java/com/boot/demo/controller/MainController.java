package com.boot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
 
  @RequestMapping("/api")
  @ResponseBody
  public String index() {
    return "Proudly handcrafted by " +
        "Hallo User :)";
  }

}
