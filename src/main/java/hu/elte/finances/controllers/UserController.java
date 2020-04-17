/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.controllers;

import hu.elte.finances.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.finances.repositories.UserRepository;

/**
 *
 * @author Xaxen
 */
@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository usersRepository;

    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }
    
    @GetMapping("")
    public ResponseEntity<Iterable<User>> getAll() {
        return ResponseEntity.ok(usersRepository.findAll());
    }
}
