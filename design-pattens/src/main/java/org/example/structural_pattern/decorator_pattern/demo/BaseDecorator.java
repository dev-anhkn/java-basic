package org.example.structural_pattern.decorator_pattern.demo;

public abstract class BaseDecorator implements Notifier {

    protected Notifier wrapper;

    BaseDecorator(Notifier notifier) {
        this.wrapper = notifier;
    }

    @Override
    public void send(String message) {
        wrapper.send(message);
    }
}
