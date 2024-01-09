package com.mailSender.email;

import com.mailSender.email.mailObj.Mail;
import jakarta.mail.MessagingException;

public interface EmailSender {
    void send(Mail mail, String content) throws MessagingException;
}
