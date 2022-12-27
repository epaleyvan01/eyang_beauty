package com.eyangbeauty.webapp.serviceImpl;

import com.eyangbeauty.webapp.mapper.ServiceMapper;
import com.eyangbeauty.webapp.model.dto.ServiceDto;
import com.eyangbeauty.webapp.repository.ServiceRepository;
import com.eyangbeauty.webapp.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements IService {
    @Autowired
    ServiceMapper serviceMapper;

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<ServiceDto> listAll() {
        return serviceRepository.findAll().stream()
                .map(serviceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceDto findById(String id) {
        return serviceMapper.toDto(serviceRepository.findById(id).get());
    }
}
