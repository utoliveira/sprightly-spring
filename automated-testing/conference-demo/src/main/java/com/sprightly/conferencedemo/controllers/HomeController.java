package com.sprightly.conferencedemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Value("${my.custom.property}")
    private String appVersion;

    @Autowired
    private Environment env;

    @GetMapping
    @RequestMapping("/")
    public Map getStatus(){
        Map map = new HashMap<String, String>();
        map.put("app-version", appVersion);
        map.put("app-version-2", env.getProperty("my.custom.property"));
        return map;
    }

}
