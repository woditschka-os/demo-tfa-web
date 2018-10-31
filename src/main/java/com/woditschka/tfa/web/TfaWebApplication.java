package com.woditschka.tfa.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
public class TfaWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(TfaWebApplication.class, args);
  }

  @GetMapping("/")
  public ModelAndView home(@Value("${tfa.hostname}") String hostname) {
    ModelMap model = new ModelMap();
    model.addAttribute("hostname", hostname);
    return new ModelAndView("home", model);
  }
}
