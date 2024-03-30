package com.example.toutiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class PageController {
    @RequestMapping("{page}")
    public String toPage(@PathVariable String page) {
        return page;
    }
}
