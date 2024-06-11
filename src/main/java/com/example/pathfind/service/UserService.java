package com.example.pathfind.service;

import com.example.pathfind.data.UserRepository;
import com.example.pathfind.web.dto.UserRegisterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegisterDTO userRegisterDTO){

    }
}
