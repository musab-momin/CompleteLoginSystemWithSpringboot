package com.reglog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController
{
    @GetMapping("/login")
    public String serveIndex(Model model)
    {
        model.addAttribute("title", "Login");
        return "login";
    }


}
