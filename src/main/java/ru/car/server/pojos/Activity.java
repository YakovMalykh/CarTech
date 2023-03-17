package ru.car.server.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("activity")
public class Activity {
    @Id
    private Long id;

    private UUID uuid;
    private Long activity;
    @Column("update_date")
    private LocalDate updateDate;
}
