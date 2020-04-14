/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.controllers;

import hu.elte.finances.entities.Users;
import hu.elte.finances.reposittories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Xaxen
 */
@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Users>> getAll() {
        return ResponseEntity.ok(usersRepository.findAll());
    }
}
