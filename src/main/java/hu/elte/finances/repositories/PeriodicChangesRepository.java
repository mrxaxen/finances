/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.repositories;

import hu.elte.finances.entities.PeriodicChanges;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Xaxen
 */
public interface PeriodicChangesRepository extends CrudRepository<PeriodicChanges, Long>{
    
}
