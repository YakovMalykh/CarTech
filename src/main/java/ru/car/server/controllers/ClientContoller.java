package ru.car.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.car.server.dto.ActivDto;
import ru.car.server.dto.InfoFromDbDto;
import ru.car.server.dto.SynchronizeDto;
import ru.car.server.pojos.UserInfo;
import ru.car.server.servicies.UserInfoService;

import java.util.UUID;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ClientContoller {
// http://localhost:8080/webjars/swagger-ui/index.html#/
    @Autowired
    UserInfoService userInfoService;

    @PostMapping
    public Mono<ResponseEntity<Void>> synchronizeInfo(@RequestBody Mono<SynchronizeDto> synchronize) {
        return userInfoService.saveUserInfo(synchronize);
    }

    @GetMapping("/{uuid}")
    public Mono<ResponseEntity<InfoFromDbDto>> getInfoByUuid(@PathVariable UUID uuid) {
        return userInfoService.getInfoByUuid(uuid).log();
    }

    @PostMapping("/activity")
    public Mono<ResponseEntity<Void>> saveActivity(@RequestBody Flux<ActivDto> activDto) {
        return userInfoService.saveActivity(activDto);
    }
}
