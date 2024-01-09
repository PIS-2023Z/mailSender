package com.mailSender.email.mailObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail implements Serializable {

    private String addressee;

    private int minutesValid;

    private MailType mailType;

    private String url;
    private String name;

    private String topic;
}

