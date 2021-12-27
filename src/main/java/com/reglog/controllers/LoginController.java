package com.reglog.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;


@Controller
public class LoginController
{


    @GetMapping("/login")
    public String serveIndex(Model model)
    {
        model.addAttribute("title", "Login");
        return "login";
    }

    @GetMapping("/defaultSuccess")
    public String handleDefault(Authentication authentication)
    {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

       for(GrantedAuthority auth: authorities)
            if( auth.toString().equals("USER")) return "redirect:/user/home";

        return "redirect:/admin/home";
    }
}
