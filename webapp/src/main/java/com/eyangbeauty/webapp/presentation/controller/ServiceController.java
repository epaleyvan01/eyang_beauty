package com.eyangbeauty.webapp.presentation.controller;

import com.eyangbeauty.webapp.model.dto.ServiceDto;
import com.eyangbeauty.webapp.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class ServiceController {
    @Autowired
    IService iService;

    @GetMapping("/about")
    public String pageAbout(){
        return "about";
    }

    @GetMapping("/price")
    public String pagePrice(){
        return "price";
    }

    @GetMapping("/contact")
    public String pageContact(){
        return "contact";
    }

    @GetMapping("/service")
    public String pageService(Model model){
        List<ServiceDto> serviceDtos = iService.listAll();
        model.addAttribute("serviceDtos", serviceDtos);
        return "service";
    }

}
