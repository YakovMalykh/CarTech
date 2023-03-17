package ru.car.server.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class SynchronizeDto {
    private UUID uuid;
    private Long money;
    private String country;
}
