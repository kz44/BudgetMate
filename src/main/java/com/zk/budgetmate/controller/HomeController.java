package com.zk.budgetmate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HomeController {

  @GetMapping("/public")
  public Map<String, String> publicEndpoint() {
    return Map.of("message", "Ez egy publikus végpont, nem kell token!");
  }


  @GetMapping("/secure")
  public Map<String, String> secureEndpoint() {
    return Map.of("message", "Ez egy VÉDETT végpont, érvényes JWT token kell!");
  }

}
