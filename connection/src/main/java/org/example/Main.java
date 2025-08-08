package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
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
        log.info("\n--- [SINGLE THREAD] ---");
        log.info("Direct connect total time: {} ms", (endDirect - startDirect));

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
        log.info("Connection pool total time: {} ms", (endPool - startPool));
        ds.close();

        // 3. Multi-thread direct connect
        log.info("\n--- [MULTI-THREAD: DIRECT CONNECT] ---");
        int threadCount = 500;
        ExecutorService executorDirect = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latchDirect = new CountDownLatch(threadCount);

        long startDirectMulti = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            final int id = i;
            executorDirect.submit(() -> {
                try (Connection conn = DriverManager.getConnection(url, username, password)) {
                    Thread.sleep(200); // giả lập query tốn thời gian
                    log.debug("Direct: Thread {} connected successfully", id);
                } catch (Exception ex) {
                    log.error("Direct: Thread {} FAILED: {}", id, ex.getMessage());
                } finally {
                    latchDirect.countDown();
                }
            });
        }
        latchDirect.await();
        executorDirect.shutdown();
        long endDirectMulti = System.currentTimeMillis();
        log.info("Direct connect (multi-thread) total time: {} ms", (endDirectMulti - startDirectMulti));

        // 4. Multi-thread connection pool
        log.info("\n--- [MULTI-THREAD: CONNECTION POOL] ---");
        HikariConfig configPool = new HikariConfig();
        configPool.setJdbcUrl(url);
        configPool.setUsername(username);
        configPool.setPassword(password);
        configPool.setMaximumPoolSize(10);
        HikariDataSource dsPool = new HikariDataSource(configPool);

        ExecutorService executorPool = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latchPool = new CountDownLatch(threadCount);

        long startPoolMulti = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            final int id = i;
            executorPool.submit(() -> {
                try (Connection conn = dsPool.getConnection()) {
                    Thread.sleep(200);
                    log.debug("Pool:   Thread {} got connection from pool", id);
                } catch (Exception ex) {
                    log.error("Pool:   Thread {} FAILED: {}", id, ex.getMessage());
                } finally {
                    latchPool.countDown();
                }
            });
        }
        latchPool.await();
        executorPool.shutdown();
        dsPool.close();
        long endPoolMulti = System.currentTimeMillis();
        log.info("Connection pool (multi-thread) total time: {} ms", (endPoolMulti - startPoolMulti));

        log.info("\n=== Kết thúc so sánh ===");
    }
}
