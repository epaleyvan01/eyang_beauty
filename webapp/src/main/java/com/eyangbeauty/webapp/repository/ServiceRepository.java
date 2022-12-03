package com.eyangbeauty.webapp.repository;

import com.eyangbeauty.webapp.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceRepository extends JpaRepository<Service, String> {
}
