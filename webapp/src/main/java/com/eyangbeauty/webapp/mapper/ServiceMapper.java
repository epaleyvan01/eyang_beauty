package com.eyangbeauty.webapp.mapper;

import com.eyangbeauty.webapp.model.dto.ServiceDto;
import com.eyangbeauty.webapp.model.entity.Service;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ServiceMapper {

    Service toEntity(ServiceDto ServiceDto);

    ServiceDto toDto(Service Service);

    void copy(ServiceDto ServiceDto, @MappingTarget Service Service);
}
