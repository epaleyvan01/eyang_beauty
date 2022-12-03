package com.eyangbeauty.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private String id;
    private String fullName;
    private String username;
    private String password;
    private String phone;
}
