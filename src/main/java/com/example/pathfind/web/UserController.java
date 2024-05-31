package com.example.pathfind.web;

import com.example.pathfind.web.dto.UserRegisterDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/users/register")
    public String viewRegister(){
        return "register";
    }


    @PostMapping("/users/register")
    public String doRegister(UserRegisterDTO userRegisterDTO){
        return "register";
    }

}
