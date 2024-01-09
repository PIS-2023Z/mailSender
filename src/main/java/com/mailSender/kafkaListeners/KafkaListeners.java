package com.mailSender.kafkaListeners;

import com.mailSender.email.SendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final SendingService sendingService;

    @KafkaListener(topics = "mail", groupId = "groupId")
    void listener(String data) {
        System.out.println("Got data: " + data);
        sendingService.registerMail();
    }
}
