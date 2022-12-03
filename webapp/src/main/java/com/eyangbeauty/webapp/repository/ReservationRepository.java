package com.eyangbeauty.webapp.repository;

import com.eyangbeauty.webapp.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
