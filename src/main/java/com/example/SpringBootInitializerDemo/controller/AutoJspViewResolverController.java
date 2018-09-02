package com.example.SpringBootInitializerDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutoJspViewResolverController {
    @RequestMapping({"page1"})
    public void handle (Model model) {
        model.addAttribute("msg", "a msg from handler1");
    }

    @RequestMapping("data/page2")
    public void handle2 (Model model) {
        model.addAttribute("msg", "a msg from handler2");
    }
}