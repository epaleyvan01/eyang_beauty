package com.eyangbeauty.webapp.service;

import com.eyangbeauty.webapp.model.dto.CustomerDto;

import java.util.List;

public interface ICustomer {
    String save(CustomerDto customerDto);
    Boolean existById(String id);
    CustomerDto findById(String id);
    CustomerDto findByEmail(String email);
    List<CustomerDto> listAll();
    void update(CustomerDto customerDto);
}
