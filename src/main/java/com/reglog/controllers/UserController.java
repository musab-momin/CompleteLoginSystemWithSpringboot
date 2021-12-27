package com.reglog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController
{
    @GetMapping("/user/home")
    public String serveHome(Model model, Principal principal)
    {

        model.addAttribute("Title", "Home");
        model.addAttribute("userName", principal.getName());
        return "home";
    }
}
