package com.revature.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/send")
    public String getStatusMessage(@RequestParam String message)
    {
        return "Message: " + message;
    }
    
}
