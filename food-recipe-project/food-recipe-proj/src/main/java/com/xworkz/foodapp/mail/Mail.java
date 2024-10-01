package com.xworkz.foodapp.mail;

import com.xworkz.foodapp.configuration.MailConfiguration;
import com.xworkz.foodapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class Mail {
    @Autowired
    public MailConfiguration mailConfiguration;

    public void sendMail(UserDTO userDTO){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userDTO.getEmailId());
        message.setSubject("WELCOME TO FOOD RECIPE");
        message.setText("UserName:" +userDTO.getFirstName()+""+"THANKS FOR JOINING THE FOOD RECIPE APP");
        mailConfiguration.mailConfig().send(message);
    }
}
