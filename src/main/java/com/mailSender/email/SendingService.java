package com.mailSender.email;

import com.mailSender.email.mailObj.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendingService {

    private final EmailService emailService;

    private final MailContentService mailContentService;

    public void registerMail(Mail mail) {
        String recipientEmail = mail.getAddressee();
        String emailSubject = "Registration";
        String emailContent = mailContentService.buildEmail(mail);

        emailService.sendEmail(recipientEmail, emailSubject, emailContent);
    }
}
