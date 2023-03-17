package ru.car.server.servicies;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import ru.car.server.dto.ActivityForAnalystsDto;
import ru.car.server.mappers.DtoMapper;
import ru.car.server.pojos.UserInfo;
import ru.car.server.repo.ActivityRepository;
import ru.car.server.repo.UserInfoRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AnalyticsService {
    @Autowired
    private UserInfoRepository userInfoRepo;
    @Autowired
    private ActivityRepository activityRepo;
    @Autowired
    private DtoMapper mapper;

    public Flux<UserInfo> getXUsersWithMaxMoneyByEachCountry(Long quantityUsers) {
        return userInfoRepo.getXUsersWithMaxMoney(quantityUsers).log();
    }

    public Flux<UserInfo> getNewUsersForPeriodByEachCountry(String startPeriod, String endPeriod) {
        return userInfoRepo.getNewUsersForPeriod(
                LocalDate.parse(startPeriod, DateTimeFormatter.ISO_LOCAL_DATE),
                LocalDate.parse(endPeriod, DateTimeFormatter.ISO_LOCAL_DATE)
        ).log();
    }

    public Flux<ActivityForAnalystsDto> getActivityOfUserByPeriod(UUID uuid, String startPeriod, String endPeriod) {
        return activityRepo.getActivityOfUser(uuid,
                LocalDate.parse(startPeriod, DateTimeFormatter.ISO_LOCAL_DATE),
                LocalDate.parse(endPeriod, DateTimeFormatter.ISO_LOCAL_DATE))
                .map(e->mapper.activityToActivityForAnalystsDto(e)).log();
    }
}
