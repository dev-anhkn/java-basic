package org.example.structural_pattern.decorator_pattern.demo;

public class DecoratorPatternDemo {

    public static void main(String[] args) {
        // Gửi qua Email + SMS + Facebook + Slack
        Notifier notifier = new SimpleNotifier();
        notifier = new SMSDecorator(notifier);
        notifier = new FacebookDecorator(notifier);
        notifier = new SlackDecorator(notifier);

        notifier.send("Bạn có thông báo mới!");
    }
}
