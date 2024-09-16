package com.techzen.academy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "") String address) { // @RequestParam

        return String.format("Hello %s - %s", name, address);
    }
}
