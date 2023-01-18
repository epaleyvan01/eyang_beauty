package com.eyangbeauty.webapp.repository;


import com.eyangbeauty.webapp.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRole(String role);

}
