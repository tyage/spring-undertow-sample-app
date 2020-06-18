package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/api/public/test")
    public String test() {
        return "test";
    }

    @GetMapping("/secret")
    public String secret() {
        return "this is secret!!!";
    }
}
