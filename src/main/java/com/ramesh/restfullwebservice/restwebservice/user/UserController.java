package com.ramesh.restfullwebservice.restwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
public class UserController {

    @Autowired
    public IUserDAO service;

    @GetMapping(path = "/users")
    public List<User> getUsers(){
        return service.findAll();
    }

    @GetMapping(path = "/users/{userId}")
    public User getUser(@PathVariable int userId){
        User user= service.findOne(userId);
        if (user == null){
            throw new UserNotFoundException("id-" +userId);
        }
        return user;
    }
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User saveUser = service.save(user);

       URI loaction =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveUser.getId()).toUri();
        return ResponseEntity.created(loaction).build();
    }
    @DeleteMapping(path = "/users/{userId}")
    public void deleteUser(@PathVariable int useId){
        User user = service.deleteById(useId);
        if (user == null){
            throw new UserNotFoundException("id-"+useId);
        }
    }
}
