package com.reglog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController
{
    @GetMapping("/user/home")
    public String serveHome(Model model)
    {
        model.addAttribute("Title", "Home");
        model.addAttribute("userName", "Musab");
        return "home";
    }
}
