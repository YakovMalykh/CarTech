package ru.car.server.servicies;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import ru.car.server.dto.ActivDto;
import ru.car.server.dto.InfoFromDbDto;
import ru.car.server.dto.SynchronizeDto;
import ru.car.server.mappers.DtoMapper;
import ru.car.server.pojos.Activity;
import ru.car.server.pojos.UserInfo;
import ru.car.server.repo.ActivityRepository;
import ru.car.server.repo.UserInfoRepository;

import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Service
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
@RequiredArgsConstructor
public class UserInfoService {
    @Autowired
    private final UserInfoRepository userInfoRepo;
    @Autowired
    private final ActivityRepository activityRepo;
    @Autowired
    private final DtoMapper mapper;

    public Mono<ResponseEntity<Void>> saveUserInfo(Mono<SynchronizeDto> infoFromClient) {

        Mono<UserInfo> userInfo = infoFromClient.map(e -> {
            UserInfo inf = mapper.synchronizeDtoToUserInfo(e);
            inf.setRegistry(LocalDate.now());
            return inf;
        }).log();

        return userInfo.flatMap(e -> userInfoRepo.findUserInfoByUuid(e.getUuid())
                .flatMap(elementFromDb -> {
                    elementFromDb.setMoney(elementFromDb.getMoney() + e.getMoney());
                   return userInfoRepo.save(elementFromDb).log()
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)));
                }).switchIfEmpty(Mono.just(e).flatMap(userInfoRepo::save)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))).log()
        ).defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    public Mono<InfoFromDbDto> getInfoByUuid(UUID uuid) {
        return userInfoRepo.findUserInfoByUuid(uuid)
                .map(mapper::userInfoToInfoFromDnDto);
//                .map(ResponseEntity::ok)
//                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    public Mono<ResponseEntity<Void>> saveActivity(Mono<ActivDto> activDtoFlux) {
        Mono<Activity> map = activDtoFlux.map(e -> {
            Activity activity = mapper.activDtoToActivity(e);
            activity.setUpdateDate(LocalDate.now());
            return activity;
        });
        // можте стоит буфферизировать перед сохранением
        return activityRepo.saveAll(map).log().then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)));
    }
}
