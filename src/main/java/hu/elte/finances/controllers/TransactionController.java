/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.controllers;

import hu.elte.finances.entities.Transaction;
import hu.elte.finances.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.finances.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    @Autowired
    private TransactionRepository repository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Transaction>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> get(@PathVariable Long id) {
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
    public ResponseEntity<Transaction> put(@PathVariable Long id, @RequestBody Transaction newTransaction) {
        Transaction entity = repository.findById(id).get();
        if(entity != null) {
            newTransaction.setId(entity.getId());
        }
        entity = repository.save(newTransaction);
        return ResponseEntity.ok(entity);
    }
}
