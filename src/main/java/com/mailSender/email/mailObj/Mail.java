package com.mailSender.email.mailObj;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mail {

    private String addressee;

    private int minutesValid;

    private MailType mailType;

    private String url;
}

