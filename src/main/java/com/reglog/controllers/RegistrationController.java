package com.reglog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController
{
    @GetMapping("/register")
    public String doRegistration(Model model)
    {
        model.addAttribute("Title", "Register");
        return "registration";
    }


}
