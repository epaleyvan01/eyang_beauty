package com.eyangbeauty.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class FormReservation {
    private String message;
    private String date;
    private String time;
    private CustomerDto customerDto;
    private String[] serviceDtos;
}
