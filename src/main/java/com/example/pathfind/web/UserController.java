package com.example.pathfind.web;

import com.example.pathfind.web.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/users/register")
    public String viewRegister() {
        return "register";
    }


    @PostMapping("/users/register")
    public String doRegister(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult) {
        //bindingResult - за да видим грешките
        if (bindingResult.hasErrors()) {
            return "register";
        }

        //препраща към login страницата
        return "redirect:/users/login";


    }

}
