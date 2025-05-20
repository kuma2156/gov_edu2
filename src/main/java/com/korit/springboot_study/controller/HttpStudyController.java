package com.korit.springboot_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
@RestController
public class HttpStudyController {

    @GetMapping("/http")
    public String get() {
        return "";
    }

    @GetMapping("/name")
    public String getName() {
        return "김명규";
    }
}
