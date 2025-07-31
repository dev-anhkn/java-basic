package org.example.creational_pattern.singleton_pattern.load_balancer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        List<String> backendServers = Arrays.asList("192.168.1.1", "192.168.1.2", "192.168.1.3");

        // Lấy instance duy nhất của Load Balancer
        RoundRobinLoadBalancer loadBalancer = RoundRobinLoadBalancer.getInstance(backendServers);

        // Mô phỏng 10 request liên tiếp
        for (int i = 0; i < 10; i++) {
            String selectedServer = loadBalancer.getNextServer();
            logger.info("Request {} -> {}", (i + 1), selectedServer);
        }
    }
}
