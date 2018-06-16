package com.ramesh.restfullwebservice.restwebservice.helloWorld;

import com.ramesh.restfullwebservice.restwebservice.helloWorld.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "hello world";
    }
    @GetMapping("hello-worldBean")
    public HelloWorldBean helloWorldBean(String msg){
        return new HelloWorldBean("hello world bean");
    }
}
