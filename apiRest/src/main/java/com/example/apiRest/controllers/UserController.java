package com.example.apiRest.controllers;

import java.util.List;
import com.example.apiRest.entities.User;
import com.example.apiRest.respositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){
        List<User> result = repository.findAll();
        return result;
    }
    @GetMapping(value ="/{id}")
    public User findById(@PathVariable Long id){
        User result = repository.findById(id).get();
        return result;
    }
    @PostMapping()
    public User insert(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id")Long id){
        repository.deleteById(id);
    }
}

