package com.reglog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController
{
    @GetMapping("/admin/home")
    public String serveHome(Model model)
    {
        model.addAttribute("Title", "Admin Home");
        model.addAttribute("adminName", "Eliot Alderson");
        return "adminhome";
    }

}
