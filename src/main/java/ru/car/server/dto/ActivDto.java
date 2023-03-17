package ru.car.server.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ActivDto {
    private UUID uuid;
    private Long activity;
}
