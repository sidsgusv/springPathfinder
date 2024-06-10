package com.example.pathfind.web;

import com.example.pathfind.web.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public String viewRegister(Model model) {
        model.addAttribute("registerData",new UserRegisterDTO());
        return "register";
    }


    @PostMapping("/register")
    public String doRegister(
            @Valid UserRegisterDTO userRegisterDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        //bindingResult - за да видим грешките
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData",userRegisterDTO);
            return "register";
        }

        //препраща към login страницата
        return "redirect:/users/login";


    }

    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }

}
