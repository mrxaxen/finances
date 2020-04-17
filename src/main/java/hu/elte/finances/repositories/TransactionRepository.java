/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.repositories;

import hu.elte.finances.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Xaxen
 */
public interface TransactionRepository extends CrudRepository<Transaction, Long>{
    
}
