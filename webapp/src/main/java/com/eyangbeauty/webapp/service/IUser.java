package com.eyangbeauty.webapp.service;

import com.eyangbeauty.webapp.model.dto.UserDto;

public interface IUser {
    UserDto findByUsername(String username);
    String save(UserDto userDto);
}
