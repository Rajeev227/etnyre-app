package com.etnyre.telematics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class MyController {
    @GetMapping("/data")
    public String getData() {
        return "Hello Etnyre Users";
    }
    @GetMapping("/message")
    public String getMessage() {
        return "Second message from AWS Ecs";
    }
}

