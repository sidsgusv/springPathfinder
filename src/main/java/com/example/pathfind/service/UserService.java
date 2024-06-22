package com.example.pathfind.service;

import com.example.pathfind.model.service.UserServiceModel;

public interface UserService {


    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);



    void loginUser(Long id, String username);

    void logout();

    UserServiceModel findById(Long id);


    boolean isNameExists(String username);
}
