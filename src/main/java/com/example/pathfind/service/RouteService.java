package com.example.pathfind.service;

import com.example.pathfind.model.service.RouteServiceModel;
import com.example.pathfind.model.view.RouteDetailsViewModel;
import com.example.pathfind.model.view.RouteViewModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RouteService {


    List<RouteViewModel> findAllRoutesView();

    void addNewRoute(RouteServiceModel routeServiceModel);

    RouteDetailsViewModel findRouteById(Long id);
}
