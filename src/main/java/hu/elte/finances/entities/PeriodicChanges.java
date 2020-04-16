/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Xaxen
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodicChanges implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @Column
    private Users user;
    
    @Column
    private Integer amount;
    //TaskScheduler needs it
    @Column
    private Long period;
    
    @Column
    private Date startDate;
    
}
