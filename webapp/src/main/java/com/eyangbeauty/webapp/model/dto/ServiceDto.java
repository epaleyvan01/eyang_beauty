package com.eyangbeauty.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceDto {
    private String id;
    private String name;
    private String description;
    private String imgPath;
}
