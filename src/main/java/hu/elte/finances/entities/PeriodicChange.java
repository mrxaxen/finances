package hu.elte.finances.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodicChange implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn
    @ManyToOne
    private User user;
    
    @Column
    private Integer amount;
    
    //TaskScheduler needs it
    @Column
    private Long period;
    
    @Column
    private Date startDate;
    
}
