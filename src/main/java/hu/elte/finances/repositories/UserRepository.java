/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.repositories;

import hu.elte.finances.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *
 * @author Xaxen
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
