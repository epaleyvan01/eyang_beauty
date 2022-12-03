package com.eyangbeauty.webapp.service;

import com.eyangbeauty.webapp.model.dto.FormReservation;
import com.eyangbeauty.webapp.model.dto.ReservationDto;

import java.util.List;

public interface IReservation {
    String save(FormReservation formReservation);
    List<ReservationDto> findAll();
    ReservationDto findById(String id);
    String update(ReservationDto reservationDto);
    void updateDatetime(String id);
}
