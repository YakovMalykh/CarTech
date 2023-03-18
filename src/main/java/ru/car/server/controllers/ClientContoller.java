package ru.car.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;
import ru.car.server.dto.ActivDto;
import ru.car.server.dto.InfoFromDbDto;
import ru.car.server.dto.SynchronizeDto;
import ru.car.server.servicies.UserInfoService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ClientContoller {
// http://localhost:8080/webjars/swagger-ui/index.html#/
    @Autowired
    UserInfoService userInfoService;

    @MessageMapping("synchronize")
    public Mono<ResponseEntity<Void>> synchronizeInfo(Mono<SynchronizeDto> synchronize) {
        return userInfoService.saveUserInfo(synchronize);
    }

    @MessageMapping("info/{uuid}")
    public Mono<InfoFromDbDto> getInfoByUuid(@DestinationVariable("uuid") UUID uuid) {
        return userInfoService.getInfoByUuid(uuid).log();
    }

    @MessageMapping("activity")
    public Mono<ResponseEntity<Void>> saveActivity(Mono<ActivDto> activDto) {
        return userInfoService.saveActivity(activDto);
    }
}
