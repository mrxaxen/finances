/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.controllers;

import hu.elte.finances.entities.Transaction;
import hu.elte.finances.entities.User;
import hu.elte.finances.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hu.elte.finances.repositories.TransactionRepository;
import hu.elte.finances.specifications.TransactionSpecification;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

@CrossOrigin
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;


    @Autowired
    private AuthenticatedUser authenticatedUser;

    @GetMapping("")
    public ResponseEntity<Iterable<Transaction>> getAll() {
        // Just test, later will be used
        User user = authenticatedUser.getUser();
        return ResponseEntity.ok(transactionRepository.findAllByUserId(user.getId()));
        //return ResponseEntity.ok(transactionRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> get(@PathVariable Integer id) {
        User user = authenticatedUser.getUser();
        Optional<Transaction> transaction = transactionRepository.findByIdAndUserId(id,user.getId());
        if (transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Transaction> post(@RequestBody Transaction transaction) {
        System.out.println(transaction);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> put(@RequestBody Transaction transaction, @PathVariable Integer id) {
        Optional<Transaction> oTransaction = transactionRepository.findById(id);
        if (oTransaction.isPresent()) {
            transaction.setId(id);
            return ResponseEntity.ok(transactionRepository.save(transaction));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Transaction> oIssue = transactionRepository.findById(id);
        if (oIssue.isPresent()) {
            System.out.println(oIssue);
            transactionRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
