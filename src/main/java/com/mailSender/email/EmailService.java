package com.mailSender.email;

import com.mailSender.email.mailObj.Mail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService implements EmailSender{

    private final JavaMailSender javaMailSender;

    @Override
    @Async
    public void send(Mail mail, String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(mail.getAddressee());
        helper.setSubject(mail.getTopic());
        helper.setText(content, false);

        javaMailSender.send(message);
    }
}
