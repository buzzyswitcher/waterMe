package de.mms.waterMe.api.Irrigations;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IrrigationDto {
    long plant_id;
    long user_id;
    int amount;
    LocalDate date;

}
