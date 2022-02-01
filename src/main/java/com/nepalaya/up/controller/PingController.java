package com.nepalaya.up.controller;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.util.LogUtil;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping(ApiConstant.PING)
public class PingController {

    @Value("${spring.application.name}")
    private String name;

    private Instant startedDate;

    public PingController() {
        this.startedDate = Instant.now();
    }

    @GetMapping
    public String ping(Model model, HttpServletRequest request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        DateTimeZone asiaKathmandu = DateTimeZone.forID("Asia/Kathmandu");
        DateTime now = startedDate.toDateTime(asiaKathmandu);

        try {
            String dateTime = dateFormat.format(now.toDate());
            model.addAttribute("startedDate", dateTime);
        } catch (Exception e) {
            LogUtil.exception(e);
        }
        model.addAttribute("name", name);
        model.addAttribute("ip_address", request.getRemoteAddr());
        return "ping";
    }
}
