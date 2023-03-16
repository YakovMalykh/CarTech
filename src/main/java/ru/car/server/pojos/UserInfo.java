package ru.car.server.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("users_info")
public class UserInfo {
    @Id
    private Long id;

    private UUID uuid;
    private Long money;
    private String country;
    private LocalDate registry;
}
