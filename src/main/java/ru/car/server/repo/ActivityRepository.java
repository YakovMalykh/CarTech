package ru.car.server.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.car.server.dto.ActivityForAnalystsDto;
import ru.car.server.pojos.Activity;
import ru.car.server.pojos.UserInfo;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface ActivityRepository extends ReactiveCrudRepository<Activity, Long> {
    @Query("SELECT * FROM activity WHERE uuid = :uuid " +
            "AND update_date BETWEEN :start AND :end ORDER BY update_date")
    Flux<Activity> getActivityOfUser(@Param("uuid")UUID uuid, @Param("start") LocalDate start, @Param("end")LocalDate end);
}
