package com.eyangbeauty.webapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "service", indexes = {
        @Index(name = "name", columnList = "name", unique = true)
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Service {
    @Id
    @Column(name = "id_service", nullable = false, length = 8)
    private String id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "img_path", nullable = false)
    private String imgPath;
}