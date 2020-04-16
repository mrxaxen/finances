/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.controllers;

import hu.elte.finances.entities.Transactions;
import hu.elte.finances.repositories.TransactionsRepository;
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
@RequestMapping("transactions")
public class TransactionsController {
    @Autowired
    private TransactionsRepository transactionsRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Transactions>> getAll() {
        return ResponseEntity.ok(transactionsRepository.findAll());
    }
}
