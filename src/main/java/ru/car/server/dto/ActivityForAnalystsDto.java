package ru.car.server.dto;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
public class ActivityForAnalystsDto {
    private Long activity;
    private LocalDate updateDate;
}
