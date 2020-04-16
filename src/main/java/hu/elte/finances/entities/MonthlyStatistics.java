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

    @ManyToOne
    @Column
    private Users user;

    @Column
    private int year;

    @Column
    private String month;

    @Column
    private int numberOfTransactions;

    @Column
    private int incomes;

    @Column
    private int expenses;

    /**Summed up balance in the end of the month*/
    @Column
    private int monthlyBalance;

    @Column
    private int amount;

    @Column
    private int countOfTransfers;
}
