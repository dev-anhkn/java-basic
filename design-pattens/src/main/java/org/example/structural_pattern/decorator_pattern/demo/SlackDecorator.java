package org.example.structural_pattern.decorator_pattern.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlackDecorator extends BaseDecorator {

    private static final Logger logger = LoggerFactory.getLogger(FacebookDecorator.class);

    SlackDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        logger.info("Sending Slack message: {}", message);
    }
}
