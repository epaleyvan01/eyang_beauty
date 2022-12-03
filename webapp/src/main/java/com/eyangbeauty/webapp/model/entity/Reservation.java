package com.eyangbeauty.webapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Table(name = "reservation", indexes = {
        @Index(name = "date_time", columnList = "date_time", unique = true)
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {
    @Id
    @Column(name = "id_reservation", nullable = false, length = 8)
    private String id;

    @Column(name = "date_time", nullable = false)
    private Instant dateTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer customer;

    @Column(name = "message")
    private String message;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "reservation_service",
            joinColumns = @JoinColumn(name = "id_reservation"),
            inverseJoinColumns = @JoinColumn(name = "id_service")
    )
    private List<Service> services;
}