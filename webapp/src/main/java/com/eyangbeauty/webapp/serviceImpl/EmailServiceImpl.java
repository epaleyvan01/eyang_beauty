package com.eyangbeauty.webapp.serviceImpl;

import com.eyangbeauty.webapp.model.dto.CustomerDto;
import com.eyangbeauty.webapp.model.dto.FormReservation;
import com.eyangbeauty.webapp.model.dto.ReservationDto;
import com.eyangbeauty.webapp.service.IEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EmailServiceImpl implements IEmail {

    @Autowired
    private JavaMailSender emailSender;


    @Override
    public void sendSimpleMessage(CustomerDto customerDto, FormReservation formReservation) {
        String newLine = System.getProperty("line.separator");
        String text = "M/Mme/Mlle " + customerDto.getFullName() + newLine +
                "Ce message vous a été envoyé pour confirmer l'enregistrement de votre réservation à Eyang Beauty & Spa. " + newLine +
                "En effet, vous avez pris rendez-vous le " + formReservation.getDate() + " à " + formReservation.getTime() + " dans notre institut. " + newLine +
                "N'oubliez pas votre rendez-vous. " + newLine +
                "Eyang Beauty and Spa, au plaisir de vous servir.";


        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@eyangbeauty.com");
        message.setTo(customerDto.getEmail());
        message.setSubject("Rendez-vous enregistré à Eyang Beauty");
        message.setText(text);
        emailSender.send(message);
    }
}
