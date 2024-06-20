package com.example.pathfind.service.impl;

import com.example.pathfind.model.entity.LevelEnum;
import com.example.pathfind.model.entity.User;
import com.example.pathfind.model.service.UserServiceModel;
import com.example.pathfind.repository.UserRepository;
import com.example.pathfind.service.UserService;
import com.example.pathfind.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user=modelMapper.map(userServiceModel,User.class);
        user.setLevel(LevelEnum.BEGINNER);
        userRepository.save(user);

    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setUsername(username);
        currentUser.setId(id);

    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }
}
