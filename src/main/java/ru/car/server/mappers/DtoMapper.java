package ru.car.server.mappers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import ru.car.server.dto.ActivDto;
import ru.car.server.dto.ActivityForAnalystsDto;
import ru.car.server.dto.InfoFromDbDto;
import ru.car.server.dto.SynchronizeDto;
import ru.car.server.pojos.Activity;
import ru.car.server.pojos.UserInfo;

@Slf4j
@Mapper
@RequiredArgsConstructor
public abstract class DtoMapper {
    public abstract UserInfo synchronizeDtoToUserInfo(SynchronizeDto synchronize);
    public abstract InfoFromDbDto userInfoToInfoFromDnDto(UserInfo userInfo);
    public abstract Activity activDtoToActivity(ActivDto activDto);
    public abstract ActivityForAnalystsDto activityToActivityForAnalystsDto(Activity activity);
}
