package com.yahuili.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public void hello(){
        System.out.println("hello,service");
    }
}
