package com.eyangbeauty.webapp.presentation.controller;

import com.eyangbeauty.webapp.model.dto.FormReservation;
import com.eyangbeauty.webapp.model.dto.ReservationDto;
import com.eyangbeauty.webapp.model.dto.ServiceDto;
import com.eyangbeauty.webapp.service.IReservation;
import com.eyangbeauty.webapp.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class ReservationController {
    @Autowired
    IService iService;

    @Autowired
    IReservation iReservation;

    @GetMapping("/")
    public String pageAccueil(Model model){return "index";}

    @GetMapping("/appointment")
    public String pageAppointment(Model model){
        List<ServiceDto> serviceDtos = iService.listAll();
        FormReservation formReservation = new FormReservation();

        model.addAttribute("serviceDtos", serviceDtos);
        model.addAttribute("formReservation", formReservation);
        return "appointment";
    }

    @PostMapping("/appointmentSave")
    public String saveAppointment(@ModelAttribute FormReservation formReservation){
        iReservation.save(formReservation);
        return "appointment_success";
    }

    @PostMapping("/updateAppointment")
    public String updateAppointment(@ModelAttribute ReservationDto reservationDto){
        iReservation.update(reservationDto);
        return "redirect:listofappointment";
    }

    @GetMapping("/listofappointment")
    public String pageListOfAppointment(Model model){
        List<ReservationDto> reservationDtos = iReservation.findAll();
        model.addAttribute("reservationDtos", reservationDtos);
        return "list_appointment";
    }

    @GetMapping("/detail")
    public String pageDetail(@RequestParam(name = "id") String id, Model model){
        ReservationDto reservationDto = iReservation.findById(id);
        model.addAttribute("reservationDto", reservationDto);
        return "detail_appointment";
    }

    @GetMapping("/cancelAppointment")
    public String cancelAppointment(@RequestParam(name = "id") String id){
        iReservation.updateDatetime(id);
        return "redirect:listofappointment";
    }

    @GetMapping("/validateAppointment")
    public String validateAppointment(@RequestParam(name = "id") String id){
        iReservation.updateDatetime(id);
        return "redirect:listofappointment";
    }
}
