/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.controllers;

import hu.elte.finances.entities.PeriodicChange;
import hu.elte.finances.repositories.PeriodicChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("periodic_changes")
public class PeriodicChangeController {
    @Autowired
    private PeriodicChangeRepository repository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<PeriodicChange>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PeriodicChange> get(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }
    
    @DeleteMapping("/del-{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/update-{id}")
    public ResponseEntity<PeriodicChange> put(@PathVariable Long id, @RequestBody PeriodicChange newEntity) {
        PeriodicChange entity = repository.findById(id).get();
        if(entity != null){
            newEntity.setId(entity.getId());
        }
        entity = repository.save(newEntity);
        return ResponseEntity.ok(entity);
    }
}
