package com.eyangbeauty.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDto {
    private static final String PATTERN_FORMAT = "yyyy-MM-dd HH:mm";
    private static final String PATTERN_FORMAT_DATE = "yyyy-MM-dd";
    private static final String PATTERN_FORMAT_TIME = "HH:mm";

    private String id;
    private Instant dateTime;
    private CustomerDto customerDto;
    private String message;
    private List<ServiceDto> serviceDtos;

    public void setDateAndTime(String string){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT).withZone(ZoneId.systemDefault());
        LocalDateTime localDateTime = LocalDateTime.parse(string, formatter);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        setDateTime(zonedDateTime.toInstant());
    }

    public String getDateForm(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT_DATE).withZone(ZoneId.systemDefault());
        return formatter.format(getDateTime());
    }
    public String getTimeForm(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT_TIME).withZone(ZoneId.systemDefault());
        return formatter.format(getDateTime());
    }

}
