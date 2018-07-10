package com.example.demo.Controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoViewController {
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Spring Boot View Demo");
        model.addAttribute("time", new Date().toString());
        return "home";
    }
}

