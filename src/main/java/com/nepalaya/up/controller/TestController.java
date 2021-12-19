package com.nepalaya.up.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public Object test(){
        return new ArrayList<>();
    }
}
