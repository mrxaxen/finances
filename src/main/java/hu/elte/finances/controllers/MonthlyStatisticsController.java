package hu.elte.finances.controllers;

import hu.elte.finances.entities.MonthlyStatistics;
import hu.elte.finances.repositories.MonthlyStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class MonthlyStatisticsController {
    @Autowired
    private MonthlyStatisticsRepository monthlyStatisticsRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<MonthlyStatistics>> getAll() {
        return ResponseEntity.ok(monthlyStatisticsRepository.findAll());
    }
}
