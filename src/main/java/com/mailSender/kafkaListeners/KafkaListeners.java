package com.mailSender.kafkaListeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mailSender.email.SendingService;
import com.mailSender.email.mailObj.Mail;
import com.mailSender.email.mailObj.MailType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final SendingService sendingService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "mail", groupId = "groupId")
    void listener(String mailStr) {
        System.out.println("Got data: " + mailStr);
        Mail mail = null;
        try {
            mail = objectMapper.readValue(mailStr, Mail.class);
        } catch (Exception e) {
            throw new RuntimeException("Deserialization error for: " + e.getMessage());
        }
        if(mail.getMailType().equals(MailType.REGISTER)) {
            sendingService.registerMail(mail);
        }
    }
}
