package org.example.creational_pattern.singleton_pattern.load_balancer;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalancer {
    // Singleton instance
    private static volatile RoundRobinLoadBalancer instance;

    // Danh sách các server backend (có thể là IP, hostname, hoặc object)
    private final List<String> servers;

    // Con trỏ vị trí server hiện tại, dùng AtomicInteger để thread-safe
    private final AtomicInteger currentIndex = new AtomicInteger(0);

    // Private constructor
    private RoundRobinLoadBalancer(List<String> servers) {
        this.servers = servers;
    }

    // Lấy instance duy nhất (Singleton - double-checked locking)
    public static RoundRobinLoadBalancer getInstance(List<String> servers) {
        if (instance == null) {
            synchronized (RoundRobinLoadBalancer.class) {
                if (instance == null) {
                    instance = new RoundRobinLoadBalancer(servers);
                }
            }
        }
        return instance;
    }

    // Lấy server tiếp theo theo vòng tròn (Round Robin)
    public String getNextServer() {
        int index = currentIndex.getAndUpdate(i -> (i + 1) % servers.size());
        return servers.get(index);
    }
}