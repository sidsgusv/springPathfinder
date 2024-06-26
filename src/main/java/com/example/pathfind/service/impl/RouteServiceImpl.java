package com.example.pathfind.service.impl;

import com.example.pathfind.model.entity.Route;
import com.example.pathfind.model.service.RouteServiceModel;
import com.example.pathfind.model.view.RouteDetailsViewModel;
import com.example.pathfind.model.view.RouteViewModel;
import com.example.pathfind.repository.RouteRepository;
import com.example.pathfind.service.CategoryService;
import com.example.pathfind.service.RouteService;
import com.example.pathfind.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository  routeRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    @Override
    public List<RouteViewModel> findAllRoutesView() {
        return routeRepository
                .findAll()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel=modelMapper.map(route, RouteViewModel.class);
                    if(route.getPictures().isEmpty()){
                        routeViewModel.setPictureUrl("/images/pic4.jpg");
                    }else {
                        routeViewModel.setPictureUrl(route.getPictures().stream().findFirst().get().getUrl());
                    }

                  return routeViewModel;
                })
                .collect(Collectors.toList());

    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {
        Route route=modelMapper.map(routeServiceModel,Route.class);

        route.setAuthor(userService.findCurrentLoginUserEntity());
        route.setCategories(routeServiceModel
                .getCategories()
                .stream()
                .map(categoryService::findCategoryByName)
                .collect(Collectors.toSet()));

        routeRepository.save(route);

    }

    @Override
    public RouteDetailsViewModel findRouteById(Long id) {
        return routeRepository.findById(id)
                .map(route -> modelMapper.map(route, RouteDetailsViewModel.class))
                .orElse(null);
    }
}
