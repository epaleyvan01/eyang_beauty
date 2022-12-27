package com.eyangbeauty.webapp.serviceImpl;

import com.eyangbeauty.webapp.mapper.CustomerMapper;
import com.eyangbeauty.webapp.mapper.ReservationMapper;
import com.eyangbeauty.webapp.mapper.ServiceMapper;
import com.eyangbeauty.webapp.model.dto.CustomerDto;
import com.eyangbeauty.webapp.model.dto.FormReservation;
import com.eyangbeauty.webapp.model.dto.ReservationDto;
import com.eyangbeauty.webapp.model.dto.ServiceDto;
import com.eyangbeauty.webapp.model.entity.Reservation;
import com.eyangbeauty.webapp.repository.ReservationRepository;
import com.eyangbeauty.webapp.service.ICustomer;
import com.eyangbeauty.webapp.service.IReservation;
import com.eyangbeauty.webapp.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationImpl implements IReservation {
    @Autowired
    ICustomer iCustomer;

    @Autowired
    ServiceMapper serviceMapper;

    @Autowired
    IService iService;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationMapper reservationMapper;

    @Override
    public String save(FormReservation formReservation) {
        Reservation reservation = new Reservation();
        //Set New Id
        String newId = "";
        Boolean isExist = true;
        while (isExist){
            Long newNumber = Math.round(Math.random()*100);
            newId = "res"+newNumber;
            if (!reservationRepository.existsById(newId)){
                isExist = false;
            }
        }
        reservation.setId(newId);

        // Check if the customer is in the data base
        CustomerDto customerDto = iCustomer.findByEmail(formReservation.getCustomerDto().getEmail());
        if (customerDto == null){
            newId = "";
            isExist = true;
            while (isExist){
                Long newNumber = Math.round(Math.random()*100);
                newId = "cust"+newNumber;
                if (!iCustomer.existById(newId)){
                    isExist = false;
                }
            }
            formReservation.getCustomerDto().setId(newId);
            String id = iCustomer.save(formReservation.getCustomerDto());
            reservation.setCustomer(customerMapper.toEntity(iCustomer.findById(id)));
        }else {
            reservation.setCustomer(customerMapper.toEntity(iCustomer.findByEmail(formReservation.getCustomerDto().getEmail())));
        }

        //Add all services
        List<com.eyangbeauty.webapp.model.entity.Service> services = new ArrayList<>();
        for(String id : formReservation.getServiceDtos()){
            ServiceDto serviceDto = iService.findById(id);
            services.add(serviceMapper.toEntity(serviceDto));
        }
        reservation.setServices(services);

        //Add dateTime
        String dateTime = formReservation.getDate() + "T" + formReservation.getTime() + ":00.00Z";
        Instant instant = Instant.parse(dateTime);
        reservation.setDateTime(instant);

        //Add messages
        reservation.setMessage(formReservation.getMessage());

        return reservationRepository.save(reservation).getId();
    }

    @Override
    public List<ReservationDto> findAll() {
        List<ReservationDto> reservationDtos = reservationRepository.findAll().stream()
                .map(reservation -> {
                    ReservationDto reservationDto = reservationMapper.toDto(reservation);
                    List<ServiceDto> serviceDtos = reservation.getServices().stream()
                            .map(serviceMapper::toDto)
                            .collect(Collectors.toList());
                    reservationDto.setServiceDtos(serviceDtos);
                    reservationDto.setCustomerDto(customerMapper.toDto(reservation.getCustomer()));
                    return reservationDto;
                })
                .collect(Collectors.toList());
        Instant newInstant = Instant.now();
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        for (ReservationDto reservationDto:reservationDtos) {
            if (reservationDto.getDateTime().isAfter(newInstant)){
                reservationDtoList.add(reservationDto);
            }
        }
        return reservationDtoList;
    }

    @Override
    public ReservationDto findById(String id) {
        Reservation reservation = reservationRepository.findById(id).get();
        ReservationDto reservationDto = reservationMapper.toDto(reservation);
        reservationDto.setServiceDtos(reservation.getServices().stream().map(serviceMapper::toDto).collect(Collectors.toList()));
        reservationDto.setCustomerDto(customerMapper.toDto(reservation.getCustomer()));
        return reservationDto;
    }

    @Override
    public String update(ReservationDto reservationDto) {
        Reservation reservation = reservationRepository.findById(reservationDto.getId()).get();
        reservationMapper.copy(reservationDto, reservation);
        iCustomer.update(reservationDto.getCustomerDto());
        reservation.setCustomer(customerMapper.toEntity(reservationDto.getCustomerDto()));
        return reservationRepository.save(reservation).getId();
    }

    @Override
    public void updateDatetime(String id) {
        Reservation reservation = reservationRepository.findById(id).get();
        reservation.setDateTime(Instant.now().minusSeconds(60));
        reservationRepository.save(reservation);
    }
}
