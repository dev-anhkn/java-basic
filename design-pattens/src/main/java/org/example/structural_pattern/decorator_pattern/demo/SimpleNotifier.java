package org.example.structural_pattern.decorator_pattern.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleNotifier implements Notifier {

    private static final Logger logger = LoggerFactory.getLogger(SimpleNotifier.class);

    @Override
    public void send(String message) {
        logger.info("SimpleNotifier: sending message: {}", message);
    }
}
