package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.constant.ResponseMsgConstant;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstant.PING)
public class PingController {

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<?> ping(){
        return ResponseEntity
                .ok()
                .body(ResponseMsgConstant.PING);
    }
}
