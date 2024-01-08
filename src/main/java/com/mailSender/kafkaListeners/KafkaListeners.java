package com.mailSender.kafkaListeners;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "mail", groupId = "groupId")
    void listener(String data) {
        System.out.println("Got data: " + data);
    }
}
