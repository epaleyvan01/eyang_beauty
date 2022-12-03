package com.eyangbeauty.webapp.mapper;

import com.eyangbeauty.webapp.model.dto.UserDto;
import com.eyangbeauty.webapp.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    void copy(UserDto userDto, @MappingTarget User user);
}
