package hu.elte.finances.repositories;

import hu.elte.finances.entities.PeriodicChanges;
import hu.elte.finances.entities.ScheduledTransactions;
import org.springframework.data.repository.CrudRepository;

public interface ScheduledTransactionsRepository extends CrudRepository<ScheduledTransactions, Long> {
}
