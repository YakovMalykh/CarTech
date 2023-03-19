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

    @Query("select * from (select users_info.*, row_number() " +
            "over (partition by country order by country, money DESC) i from users_info) t where i <= :quantityUsers")
    Flux<UserInfo> getXUsersWithMaxMoney(@Param("quantityUsers") Long quantityUsers);


}
