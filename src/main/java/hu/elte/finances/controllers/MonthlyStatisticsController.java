package hu.elte.finances.controllers;

import hu.elte.finances.entities.MonthlyStatistics;
import hu.elte.finances.repositories.MonthlyStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("statistics")
public class MonthlyStatisticsController {
    @Autowired
    private MonthlyStatisticsRepository repository;

    @GetMapping("")
    public ResponseEntity<Iterable<MonthlyStatistics>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/get{id}")
    public ResponseEntity<MonthlyStatistics> get(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }

    /*@PostMapping("/post")
    public RepsonseEntity<MonthlyStatistics> post(@RequestBody MonthlyStatistics mstat) {
        return ResponseEntity.badRequest().build();
    }*/
    
    @DeleteMapping("/del{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    //Statisztikát manuálisan hozzáadni nem fogunk
    /*@PutMapping("/put{id}")
    public ResponseEntity<MonthlyStatistics> put(@PathVariable Long id, @RequestBody MonthlyStatistics newEntity) {
        MonthlyStatistics entity = repository.findById(id).get();
        if(entity != null){
            newEntity.setId(entity.getId());
        }
        entity = repository.save(newEntity);
        return ResponseEntity.ok(entity);
    }*/
}
