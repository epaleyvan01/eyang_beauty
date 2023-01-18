package com.eyangbeauty.webapp.presentation.controller;

import com.eyangbeauty.webapp.model.dto.UserDto;
import com.eyangbeauty.webapp.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    IUser iUser;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute UserDto userDto, Model model){
        String successMessage = iUser.save(userDto);
        UserDto userDto2 = new UserDto();
        model.addAttribute("user", userDto2);
        model.addAttribute("successMessage", successMessage);
        return "registration";
    }
}
