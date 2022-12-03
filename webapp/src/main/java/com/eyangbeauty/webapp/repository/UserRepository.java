package com.eyangbeauty.webapp.repository;

import com.eyangbeauty.webapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
