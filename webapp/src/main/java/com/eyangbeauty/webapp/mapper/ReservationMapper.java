package com.eyangbeauty.webapp.mapper;

import com.eyangbeauty.webapp.model.dto.ReservationDto;
import com.eyangbeauty.webapp.model.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ReservationMapper {

    Reservation toEntity(ReservationDto ReservationDto);

    ReservationDto toDto(Reservation Reservation);

    void copy(ReservationDto ReservationDto, @MappingTarget Reservation Reservation);
}