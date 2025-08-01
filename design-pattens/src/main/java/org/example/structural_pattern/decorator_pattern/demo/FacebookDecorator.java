package org.example.structural_pattern.decorator_pattern.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FacebookDecorator extends BaseDecorator {

    private static final Logger logger = LoggerFactory.getLogger(FacebookDecorator.class);

    FacebookDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendFacebook(message);
    }

    private void sendFacebook(String message) {
        logger.info("Sending Facebook message: {}", message);
    }
}
