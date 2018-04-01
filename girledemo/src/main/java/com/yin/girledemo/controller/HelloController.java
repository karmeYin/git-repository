package com.yin.girledemo.controller;

import com.yin.girledemo.properties.GirleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private GirleProperties girleProperties;
    @GetMapping(value = "/hello")
    public GirleProperties say(){
     return girleProperties;
    }
}
