package ru.car.server.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.car.server.pojos.UserInfo;

import java.util.UUID;

public interface UserInfoRepository extends ReactiveCrudRepository<UserInfo, Long> {
    Mono<UserInfo> findUserInfoByUuid(UUID uuid);

}
