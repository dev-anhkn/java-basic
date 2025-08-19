package org.example.asynchronous_combine.allof;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class FlightSearchMain {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("[Main] Bắt đầu gọi các API");
        // Chạy các tác vụ với delay ngẫu nhiên
        CompletableFuture<List<String>> future1 = CompletableFuture.supplyAsync(new FlightSearchTask("Vietnam Airline"));
        CompletableFuture<List<String>> future2 = CompletableFuture.supplyAsync(new FlightSearchTask("VietJet"));
        CompletableFuture<List<String>> future3 = CompletableFuture.supplyAsync(new FlightSearchTask("Bamboo"));

        // Chờ tất cả hoàn thành
        CompletableFuture<Void> allFlights = CompletableFuture.allOf(future1, future2, future3);

        allFlights.thenRun(new Runnable() {
            @Override
            public void run() {
                try {
                    List<String> allResults = new ArrayList<>();
                    allResults.addAll(future1.get());
                    allResults.addAll(future2.get());
                    allResults.addAll(future3.get());

                    System.out.println("Tổng hợp danh sách chuyến bay sau " + (System.currentTimeMillis() - start)/1000 + " giây");
                    for (String s : allResults){
                        System.out.println(s);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("[Main] Main vẫn tiếp tục làm việc khác");
        try {
            TimeUnit.SECONDS.sleep(10); // Chờ để quan sát kết quả
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
