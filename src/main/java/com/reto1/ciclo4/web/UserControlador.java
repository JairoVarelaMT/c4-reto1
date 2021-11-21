package com.reto1.ciclo4.web;

import java.util.List;
import java.util.Optional;

import com.reto1.ciclo4.model.User;
import org.springframework.http.HttpStatus;
import com.reto1.ciclo4.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class UserControlador {
    @Autowired
    private UserService userservice;
    //
    @GetMapping("/all")
    public List<User> getUser(){
        return userservice.getAll();
    }
    @GetMapping("/{email}")
    public Optional<User> findByEmail(@PathVariable("email") String correo){
        return userservice.findByEmail(correo);
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User usuario){
        return userservice.save(usuario);
    }
}