package com.rest.api.restapispringboot.controller;

import java.util.List;
import java.util.NoSuchElementException;
import com.rest.api.restapispringboot.model.User;
import com.rest.api.restapispringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> list(){

        return userService.listAllUsers();

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id){

        try{

            User user = userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);

        }catch(NoSuchElementException e){

            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

        }

    }

    @PostMapping("/")
    public void add(@RequestBody User user){

        userService.saveUser(user);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id){

        try{

            user.setId(id);
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch(NoSuchElementException e){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){

        userService.deleteUser(id);

    }

}
