package hu.elte.finances.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn
    @ManyToOne
    private User user;

    @Column
    private Integer year;

    @Column
    private String month;

    @Column
    private Integer numberOfTransactions;

    @Column
    private Integer incomes;

    @Column
    private Integer expenses;

    /**Summed up balance in the end of the month*/
    @Column
    private Integer monthlyBalance;

    @Column
    private Integer amount;

    @Column
    private Integer countOfTransfers;
}
