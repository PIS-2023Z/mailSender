package com.mailSender.email;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendingService {

    private final EmailService emailService;

    private final MailContentService mailContentService;

    public void registerMail() {
        String recipientEmail = "piotr.kow.59@gmail.com";
        String emailSubject = "Temat wiadomości";
        String emailContent = "Treść wiadomości";

        emailService.sendEmail(recipientEmail, emailSubject, emailContent);
    }
}
