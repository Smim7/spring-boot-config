package io.javabrains.spring_boot_config.controller;

import io.javabrains.spring_boot_config.DbSetting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {
  @Autowired
  private DbSetting dbSetting;
  @Autowired
  private Environment env;

   @Value("${my.greeting}")
    private String greetingMessage;
   @Value("some static message")
   private  String staticMessage;
   @Value("${my.name : default value}")
   private String myName;
   @Value("${my.list.values}")
   private List<String> listvalue;
  // @Value("#{${dbValues}}")
  // private Map<String,String> dbValues;


   @GetMapping("/greeting")
   public String greeting(){
        return dbSetting.toString();
   }
   @GetMapping("/envdetails")
    public String envDetails(){
       return env.toString();
   }

}
