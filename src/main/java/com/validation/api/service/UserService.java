package com.validation.api.service;

import com.validation.api.dto.UserRequest;
import com.validation.api.entity.User;
import com.validation.api.exception.UserNotFoundException;
import com.validation.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(UserRequest userRequest){
            //these below comment lines need to add when we use staticName = build in entity & dto classes
//        User user = User.build(0, userRequest.getName(), userRequest.getEmail(),
//                userRequest.getGender(), userRequest.getMobile(), userRequest.getAge(), userRequest.getNationality());
        User user = new User(0, userRequest.getName(), userRequest.getEmail(),
                userRequest.getGender(), userRequest.getMobile(), userRequest.getAge(), userRequest.getNationality());
        return repository.save(user);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = repository.findByUserId(id);
        if(user != null){
            return user;
        } else{
            throw new UserNotFoundException("user not found with id:"+" "+id);
        }
    }
}
