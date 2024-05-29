package com.example.pathfind.service;

import com.example.pathfind.data.RouteRepository;
import com.example.pathfind.model.Picture;
import com.example.pathfind.model.Route;
import com.example.pathfind.service.dto.RouteShortInfoDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {

    private RouteRepository routeRepository;
    private Random random;

    private ModelMapper modelMapper;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;

        this.modelMapper=new ModelMapper();
        this.random=new Random();
    }
@Transactional
    public List<RouteShortInfoDTO> getAll(){
      return   routeRepository.findAll()
                .stream()
                .map(this::mapToShortInfo)
                .toList();
    }


    @Transactional
    public RouteShortInfoDTO getRandomRoute(){

        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount) + 1;

        Optional<Route> route = routeRepository.findById(randomId);




        if (route.isEmpty()){
            //throw exception; return empty
        }


        return mapToShortInfo(route.get());

    }

    private RouteShortInfoDTO mapToShortInfo(Route route){
        RouteShortInfoDTO dto = modelMapper.map(route,RouteShortInfoDTO.class);
        Optional<Picture> first = route.getPictures().stream().findFirst();
        dto.setImageUrl(first.get().getUrl());

        return dto;

    }

}
