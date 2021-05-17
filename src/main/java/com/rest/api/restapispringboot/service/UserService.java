package com.rest.api.restapispringboot.service;

import java.util.List;

import com.rest.api.restapispringboot.model.User;
import com.rest.api.restapispringboot.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUsers(){

        return userRepository.findAll();

    }
    
    public void saveUser(User user){

        userRepository.save(user);

    }

    public User getUser(Integer id){

        return userRepository.findById(id).get();

    }

    public void deleteUser(Integer id){

        userRepository.deleteById(id);

    }

}
