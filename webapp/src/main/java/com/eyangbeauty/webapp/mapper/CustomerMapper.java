package com.eyangbeauty.webapp.mapper;

import com.eyangbeauty.webapp.model.dto.CustomerDto;
import com.eyangbeauty.webapp.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface CustomerMapper {

    Customer toEntity(CustomerDto CustomerDto);

    CustomerDto toDto(Customer Customer);

    void copy(CustomerDto CustomerDto, @MappingTarget Customer Customer);
}
