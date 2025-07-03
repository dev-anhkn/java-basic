package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5431/db_project";
        String username = "u_account";
        String password = "u_account";

        int loops = 100;

        // 1. Đo thời gian direct connect (single thread)
        long startDirect = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) {
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                // chỉ connect và close
            }
        }
        long endDirect = System.currentTimeMillis();
        System.out.println("\n--- [SINGLE THREAD] ---");
        System.out.println("Direct connect total time: " + (endDirect - startDirect) + " ms");

        // 2. Đo thời gian connection pool (single thread)
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(10);
        HikariDataSource ds = new HikariDataSource(config);

        long startPool = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) {
            try (Connection conn = ds.getConnection()) {
                // mượn và trả connection từ pool
            }
        }
        long endPool = System.currentTimeMillis();
        System.out.println("Connection pool total time: " + (endPool - startPool) + " ms");
        ds.close();

        // 3. Multi-thread direct connect
        System.out.println("\n--- [MULTI-THREAD: DIRECT CONNECT] ---");
        int threadCount = 500;
        ExecutorService executorDirect = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latchDirect = new CountDownLatch(threadCount);

        long startDirectMulti = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            final int id = i;
            executorDirect.submit(() -> {
                try (Connection conn = DriverManager.getConnection(url, username, password)) {
                    Thread.sleep(200); // giả lập query tốn thời gian
                    System.out.println("Direct: Thread " + id + " connected successfully");
                } catch (Exception ex) {
                    System.err.println("Direct: Thread " + id + " FAILED: " + ex.getMessage());
                } finally {
                    latchDirect.countDown();
                }
            });
        }
        latchDirect.await();
        executorDirect.shutdown();
        long endDirectMulti = System.currentTimeMillis();
        System.out.println("Direct connect (multi-thread) total time: " + (endDirectMulti - startDirectMulti) + " ms");

        // 4. Multi-thread connection pool
        System.out.println("\n--- [MULTI-THREAD: CONNECTION POOL] ---");
        HikariConfig configPool = new HikariConfig();
        configPool.setJdbcUrl(url);
        configPool.setUsername(username);
        configPool.setPassword(password);
        configPool.setMaximumPoolSize(10); // tối đa 10 connection
        HikariDataSource dsPool = new HikariDataSource(configPool);

        ExecutorService executorPool = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latchPool = new CountDownLatch(threadCount);

        long startPoolMulti = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            final int id = i;
            executorPool.submit(() -> {
                try (Connection conn = dsPool.getConnection()) {
                    Thread.sleep(200); // giả lập query tốn thời gian
                    System.out.println("Pool:   Thread " + id + " got connection from pool");
                } catch (Exception ex) {
                    System.err.println("Pool:   Thread " + id + " FAILED: " + ex.getMessage());
                } finally {
                    latchPool.countDown();
                }
            });
        }
        latchPool.await();
        executorPool.shutdown();
        dsPool.close();
        long endPoolMulti = System.currentTimeMillis();
        System.out.println("Connection pool (multi-thread) total time: " + (endPoolMulti - startPoolMulti) + " ms");

        System.out.println("\n=== Kết thúc so sánh ===");
    }
}