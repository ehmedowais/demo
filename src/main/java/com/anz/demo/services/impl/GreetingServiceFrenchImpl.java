package com.anz.demo.services.impl;

import com.anz.demo.services.IGreetingService;
import org.springframework.stereotype.Component;

@Component("greeting.french")
public class GreetingServiceFrenchImpl implements IGreetingService {
    public String sayHello(String name) {
        return "Bonjour " + name;
    }
}
