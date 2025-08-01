package org.example.structural_pattern.decorator_pattern.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSDecorator extends BaseDecorator {

    private static final Logger logger = LoggerFactory.getLogger(SMSDecorator.class);

    SMSDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // gửi qua các kênh trước (ví dụ: Email)
        sendSMS(message);    // rồi gửi SMS
    }

    private void sendSMS(String message) {
        logger.info("SMSDecorator sending message to {}", message);
    }
}

