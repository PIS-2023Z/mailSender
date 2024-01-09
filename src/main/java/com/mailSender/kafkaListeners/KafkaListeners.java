package com.mailSender.kafkaListeners;

import com.mailSender.email.SendingService;
import com.mailSender.email.mailObj.Mail;
import com.mailSender.email.mailObj.MailType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final SendingService sendingService;

    //TODO deserialize
    @KafkaListener(topics = "mail", groupId = "groupId")
    void listener(Mail mail) {
        System.out.println("Got data: " + mail);
        if(mail.getMailType().equals(MailType.REGISTER)) {
            sendingService.registerMail(mail);
        }
    }
}
