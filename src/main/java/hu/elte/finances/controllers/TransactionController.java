/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.controllers;

import hu.elte.finances.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.finances.repositories.TransactionRepository;

/**
 *
 * @author Xaxen
 */
@RestController
@RequestMapping("transactions")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionsRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Transaction>> getAll() {
        return ResponseEntity.ok(transactionsRepository.findAll());
    }
}
