package com.anz.demo.controller;

import com.anz.demo.services.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetingsController {
    @Autowired
    private IGreetingService greetingService;
    @GetMapping(path="/greetings")
    public ResponseEntity<String> greetings() {
        return ResponseEntity.ok(greetingService.sayHello("Muhammad Ahmed"));
    }
}
