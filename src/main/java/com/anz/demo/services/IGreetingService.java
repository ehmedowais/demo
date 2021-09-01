package com.anz.demo.services;

import org.ff4j.aop.Flip;

public interface IGreetingService {
    @Flip(name="language-french", alterBean="greeting.french")
    String sayHello(String name);
}
