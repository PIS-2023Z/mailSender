package com.mailSender.email.mailObj;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import java.io.IOException;

public class MailDeserializer implements Deserializer<Mail> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Mail deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, Mail.class);
        } catch (IOException e) {
            throw new RuntimeException("Błąd deserializacji obiektu Mail: " + e.getMessage());
        }
    }

}
