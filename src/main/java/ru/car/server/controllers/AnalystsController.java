package ru.car.server.controllers;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.car.server.dto.ActivityForAnalystsDto;
import ru.car.server.pojos.Newcomers;
import ru.car.server.pojos.UserInfo;
import ru.car.server.servicies.AnalyticsService;

import java.util.UUID;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class AnalystsController {
    @Autowired
    private AnalyticsService analyticsService;

    @Operation(summary = "X пользователей с наибольшим money по каждой стране")
    @GetMapping("/max-money")
    public Flux<UserInfo> getXUsersWithMaxMoneyByEachCountry(@RequestParam Long quantityUsers) {
        return analyticsService.getXUsersWithMaxMoneyByEachCountry(quantityUsers);
    }

    @Operation(summary = "количество новых пользователей за период")
    @GetMapping("/newcomer")
    public Flux<Newcomers> getNewUsersForPeriodByEachCountry(
            @Parameter(description = "format YYYY-MM-DD") @RequestParam String start,
            @Parameter(description = "format YYYY-MM-DD") @RequestParam String end) {
        return analyticsService.getNewUsersForPeriodByEachCountry(start, end);
    }
    @Operation(summary = "для пользователя Х получить отсортированный список activity и даты за период")
    @GetMapping("/activity")
    public Flux<ActivityForAnalystsDto> getActivityOfUserByPeriod(
            @Parameter(description = "UUID") @RequestParam UUID uuid,
            @Parameter(description = "format YYYY-MM-DD") @RequestParam String start,
            @Parameter(description = "format YYYY-MM-DD") @RequestParam String end
    ) {
        return analyticsService.getActivityOfUserByPeriod(uuid, start, end);
    }
}
