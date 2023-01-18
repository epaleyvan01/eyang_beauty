package com.eyangbeauty.webapp.serviceImpl;

import com.eyangbeauty.webapp.mapper.UserMapper;
import com.eyangbeauty.webapp.model.dto.UserDto;
import com.eyangbeauty.webapp.model.entity.Role;
import com.eyangbeauty.webapp.model.entity.User;
import com.eyangbeauty.webapp.repository.RoleRepository;
import com.eyangbeauty.webapp.repository.UserRepository;
import com.eyangbeauty.webapp.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserImpl implements IUser {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDto findByUsername(String username) {
        return userMapper.toDto(userRepository.findByUsername(username));
    }

    @Override
    public String save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        Boolean isIdNotNew = true;
        String id = "";
        while (isIdNotNew){
            long code = Math.round(Math.random() * 100);
            id = "us" + code;
            if(!userRepository.existsById(id)){
                isIdNotNew = false;
            }
        }
        user.setId(id);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        final Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user).getId();
    }
}
