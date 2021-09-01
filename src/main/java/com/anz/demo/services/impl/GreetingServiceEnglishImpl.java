package com.anz.demo.services.impl;

import com.anz.demo.services.IGreetingService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("greeting.english")
@Primary
public class GreetingServiceEnglishImpl implements IGreetingService {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
