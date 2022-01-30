package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping(ApiConstant.PING)
public class PingController {

    @Value("${spring.application.name}")
    private String name;

    private Date startedDate;

    public PingController() {
        this.startedDate = new Date();
    }

    @GetMapping
    public String ping(Model model) {
        model.addAttribute("startedDate", "started at: " + startedDate);
        model.addAttribute("name", name);
        return "ping";
    }
}
