package com.reglog.service;

import com.reglog.dao.UserRepo;
import com.reglog.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationService
{

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder encoder;

    public String doRegistration(User appUser)
    {
        Optional<User> duplicateUser = userRepo.getByEmail(appUser.getEmail());
        if(duplicateUser.isPresent())  return "DUPLICATE";
        appUser.setPassword(encoder.encode(appUser.getPassword()));
        appUser.setRole("USER");
        appUser.setRegisterDate(LocalDate.now());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        appUser.setRegisterTime(LocalTime.now().format(dtf));
        try{
            userRepo.save(appUser);
            return "SAVED";
        }catch (Exception ae){
            ae.printStackTrace();
            return "ERROR";
        }
    }

    public ResponseEntity<?> registerUser(User appUser)
    {
        String flag = doRegistration(appUser);
        if(flag.equals("SAVED") ) {
            Map<String, String> successResponse = new HashMap<>();
            successResponse.put("status", "200");
            successResponse.put("defaultMessage", "Registered Successfully");
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        }else if(flag.equals("DUPLICATE")){
            Map<String, String> duplicateResponse = new HashMap<>();
            duplicateResponse.put("status", "400");
            duplicateResponse.put("defaultMessage", "Email is already registered");
            return new ResponseEntity<>(duplicateResponse, HttpStatus.BAD_REQUEST);
        }else{
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "400");
            errorResponse.put("defaultMessage", "Something went wrong on server");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

}
