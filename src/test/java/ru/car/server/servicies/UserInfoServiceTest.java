package ru.car.server.servicies;

import com.sun.jdi.LongValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.car.server.ConstanrsForTest;
import ru.car.server.dto.ActivDto;
import ru.car.server.pojos.Activity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static ru.car.server.ConstanrsForTest.*;

//@ActiveProfiles("test")
//@DataR2dbcTest
//@DirtiesContext
//@ExtendWith((MockitoExtension.class))
class UserInfoServiceTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void saveUserInfo() {
    }

    @Test
    void getInfoByUuid() {
    }
    @Test
    void saveActivity() {


    }
}