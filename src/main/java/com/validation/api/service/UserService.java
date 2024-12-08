package com.validation.api.service;

import com.validation.api.dto.UserRequest;
import com.validation.api.entity.User;
import com.validation.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(UserRequest userRequest){
        User user = new User(0, userRequest.getName(), userRequest.getEmail(),
                userRequest.getGender(), userRequest.getMobile(), userRequest.getAge(), userRequest.getNationality());
        return repository.save(user);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getUser(int id){
        return repository.findByUserId(id);
    }
}