package com.bookstores.bookstores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ErrorController{

    @GetMapping("/access-Denied")
    public String accessDenied() {
        return "accessDenied";
    }
}