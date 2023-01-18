package com.eyangbeauty.webapp.service;

import com.eyangbeauty.webapp.model.dto.CustomerDto;
import com.eyangbeauty.webapp.model.dto.FormReservation;
import com.eyangbeauty.webapp.model.dto.ReservationDto;

public interface IEmail {
    void sendSimpleMessage(CustomerDto customerDto, FormReservation formReservation);
}
