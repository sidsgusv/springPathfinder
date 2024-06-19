package com.example.pathfind.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @GetMapping("/register")
    public String register(){
        //return imeto na template
        return "register";
    }
//    @PostMapping("/register")
//    public String registerConfirm(@Valid UserRegisterBindingDTO userRegisterBindingDTO,
//                                  BindingResult bindingResult) {
//
//        return "redirect:/";
//    }

    @GetMapping("/login")
    public String login(){
        //return imeto na template
        return "login";
    }




}
