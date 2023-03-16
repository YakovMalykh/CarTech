package ru.car.server.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InfoFromDbDto {
    private Long money;
    private String country;
    private LocalDate registry;
}
