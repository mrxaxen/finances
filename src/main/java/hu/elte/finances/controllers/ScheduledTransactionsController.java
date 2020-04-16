package hu.elte.finances.controllers;

import hu.elte.finances.entities.PeriodicChanges;
import hu.elte.finances.entities.ScheduledTransactions;
import hu.elte.finances.repositories.PeriodicChangesRepository;
import hu.elte.finances.repositories.ScheduledTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scheduled_transactions")
public class ScheduledTransactionsController {
    @Autowired
    private ScheduledTransactionsRepository scheduledTransactionsRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<ScheduledTransactions>> getAll() {
        return ResponseEntity.ok(scheduledTransactionsRepository.findAll());
    }
}

