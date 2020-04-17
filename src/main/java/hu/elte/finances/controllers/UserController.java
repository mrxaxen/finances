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
import hu.elte.finances.repositories.UserRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String home(){
        return "home.jsp";
    }
    
    @GetMapping("")
    public ResponseEntity<Iterable<User>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }

    /*@PostMapping("")
    public RepsonseEntity<Foo> post(@RequestBody Foo foo) {}*/

    @DeleteMapping("/del-{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-{id}")
    public ResponseEntity<User> put(@PathVariable Long id, @RequestBody User newUser) {
        User entity = repository.findById(id).get();
        if(entity != null) {
            newUser.setId(entity.getId());
        }
        entity = repository.save(newUser);
        return ResponseEntity.ok(entity);
    }
}