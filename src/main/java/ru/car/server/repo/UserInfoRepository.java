package ru.car.server.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.car.server.pojos.Newcomers;
import ru.car.server.pojos.UserInfo;

import java.time.LocalDate;
import java.util.UUID;

public interface UserInfoRepository extends ReactiveCrudRepository<UserInfo, Long> {
    Mono<UserInfo> findUserInfoByUuid(UUID uuid);
    @Query("SELECT * FROM users_info ORDER BY country DESC, money DESC  LIMIT :quantityUsers")
    Flux<UserInfo> getXUsersWithMaxMoney(@Param("quantityUsers") Long quantityUsers);


}
