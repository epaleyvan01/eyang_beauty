package com.eyangbeauty.webapp.service;

import com.eyangbeauty.webapp.model.dto.ServiceDto;

import java.util.List;

public interface IService {
    List<ServiceDto> listAll();
    ServiceDto findById(String id);
}
