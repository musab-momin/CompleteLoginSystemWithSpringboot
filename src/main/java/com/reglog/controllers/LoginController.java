package com.reglog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController
{
    @GetMapping("/login")
    public String serveIndex(Model model)
    {
        model.addAttribute("title", "Login");
        return "index";
    }


}
