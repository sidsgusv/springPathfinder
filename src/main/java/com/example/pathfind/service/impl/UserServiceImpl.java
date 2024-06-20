package com.example.pathfind.service.impl;

import com.example.pathfind.model.entity.LevelEnum;
import com.example.pathfind.model.entity.User;
import com.example.pathfind.model.service.UserServiceModel;
import com.example.pathfind.repository.UserRepository;
import com.example.pathfind.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user=modelMapper.map(userServiceModel,User.class);
        user.setLevel(LevelEnum.BEGINNER);
        userRepository.save(user);

    }
}
