package ru.car.server.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.car.server.pojos.Activity;

import java.util.UUID;

@Repository
public interface ActivityRepository extends ReactiveCrudRepository<Activity, Long> {
    Mono<Activity> findActivityByUuid(UUID uuid);
}
