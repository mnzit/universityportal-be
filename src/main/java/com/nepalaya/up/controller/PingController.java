package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.util.LogUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
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
    public String ping(Model model, HttpServletRequest request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            String dateTime = dateFormat.format(startedDate);
            model.addAttribute("startedDate", name + " started at: " + dateTime);
        } catch (Exception e) {
            LogUtil.exception(e);
        }
        model.addAttribute("name", name);
        model.addAttribute("ip_address", request.getRemoteAddr());
        return "ping";
    }
}
