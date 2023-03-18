package ru.car.server.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import ru.car.server.pojos.Newcomers;

import java.time.LocalDate;

public interface NewcomersRepository extends ReactiveCrudRepository<Newcomers, Long> {
    @Query("SELECT country, COUNT(*)  FROM users_info WHERE registry BETWEEN :start AND :end GROUP BY country ORDER BY country DESC ")
    Flux<Newcomers> getAmountNewUsersForPeriod(@Param("start") LocalDate start, @Param("end")LocalDate end);
}
