package hu.elte.finances.repositories;

import hu.elte.finances.entities.MonthlyStatistics;
import hu.elte.finances.entities.ScheduledTransactions;
import org.springframework.data.repository.CrudRepository;

public interface MonthlyStatisticsRepository extends CrudRepository<MonthlyStatistics, Long> {
}
