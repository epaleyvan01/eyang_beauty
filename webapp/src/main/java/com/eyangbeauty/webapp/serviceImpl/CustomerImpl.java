package com.eyangbeauty.webapp.serviceImpl;

import com.eyangbeauty.webapp.mapper.CustomerMapper;
import com.eyangbeauty.webapp.model.dto.CustomerDto;
import com.eyangbeauty.webapp.model.entity.Customer;
import com.eyangbeauty.webapp.repository.CustomerRepository;
import com.eyangbeauty.webapp.service.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerImpl implements ICustomer {
    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String save(CustomerDto customerDto) {
        if(!customerRepository.existsById(customerDto.getId())){
            return customerRepository.save(customerMapper.toEntity(customerDto)).getId();
        }
        return null;
    }

    @Override
    public Boolean existById(String id) {
        return customerRepository.existsById(id);
    }

    @Override
    public CustomerDto findById(String id) {
        return customerMapper.toDto(customerRepository.findById(id).get());
    }

    @Override
    public CustomerDto findByEmail(String email) {
        if(customerRepository.existsByEmail(email)){
            Customer customer = customerRepository.findByEmail(email).get();
            return customerMapper.toDto(customer);
        }
        return null;
    }

    @Override
    public List<CustomerDto> listAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void update(CustomerDto customerDto) {
        customerRepository.save(customerMapper.toEntity(customerDto));
    }
}
