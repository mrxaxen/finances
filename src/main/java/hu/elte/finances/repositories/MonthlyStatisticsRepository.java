package hu.elte.finances.repositories;

import hu.elte.finances.entities.MonthlyStatistics;
import org.springframework.data.repository.CrudRepository;

public interface MonthlyStatisticsRepository extends CrudRepository<MonthlyStatistics, Long> {
}
