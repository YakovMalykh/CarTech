package ru.car.server.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.car.server.dto.ActivityForAnalystsDto;
import ru.car.server.pojos.Activity;
import ru.car.server.pojos.UserInfo;
import ru.car.server.servicies.AnalyticsService;
import ru.car.server.servicies.UserInfoService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class AnalystsController {
    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/max-money")
    public Flux<UserInfo> getXUsersWithMaxMoneyByEachCountry(@RequestParam Long quantityUsers) {
        return analyticsService.getXUsersWithMaxMoneyByEachCountry(quantityUsers);
    }

    @GetMapping("/newcomer")
    public Flux<UserInfo> getNewUsersForPeriodByEachCountry(
            @Parameter(description = "format YYYY-MM-DD") @RequestParam String start,
            @Parameter(description = "format YYYY-MM-DD") @RequestParam String end) {
        return analyticsService.getNewUsersForPeriodByEachCountry(start, end);
    }

    @GetMapping("/activity")
    public Flux<ActivityForAnalystsDto> getActivityOfUserByPeriod(
            @Parameter(description = "UUID") @RequestParam UUID uuid,
            @Parameter(description = "format YYYY-MM-DD") @RequestParam String start,
            @Parameter(description = "format YYYY-MM-DD") @RequestParam String end
    ) {
        return analyticsService.getActivityOfUserByPeriod(uuid, start, end);
    }
}