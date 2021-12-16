package com.nepalaya.up.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<?> ping(){
        return ResponseEntity
                .ok()
                .body("<h1 style='font-size:30px;color:#AA3939;text-align:center;margin-top:50px;'>University Portal is running!</h1>");
    }
}
