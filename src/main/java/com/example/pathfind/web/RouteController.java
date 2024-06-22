package com.example.pathfind.web;


import com.example.pathfind.service.RouteService;
import com.example.pathfind.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/routes")
public class RouteController {
    private final RouteService routeService;
    private final CurrentUser currentUser;

    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.routeService = routeService;

        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }



    @GetMapping("/all")
    public String allRoutes(){


//        model.addAttribute("routes",routeService
//                .findAllRoutesView());

        return "routes";
    }




}
