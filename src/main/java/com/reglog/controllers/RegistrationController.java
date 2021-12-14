package com.reglog.controllers;

import com.reglog.entity.User;
import com.reglog.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


@Controller
@AllArgsConstructor
public class RegistrationController
{

    private RegistrationService registrationService;


    @GetMapping("/register")
    public String doRegistration(Model model)
    {
        model.addAttribute("Title", "Register");
        return "registration";
    }

    @PostMapping("/handleRegistration")
    public ResponseEntity<?> handleRegistration(@Valid @ModelAttribute("appUser") User appUser, BindingResult result)
    {
        ResponseEntity<?> response;

        if(result.hasErrors()) return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        else   response = registrationService.registerUser(appUser);

       return response;
    }

}
