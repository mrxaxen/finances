package hu.elte.finances.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class ScheduledTransactions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn
    @ManyToOne
    private Users user;

    @Column
    private Date dayOfScheduledTransaction;

    @Column
    private Integer change;
}
