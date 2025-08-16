package org.example.thread_pool.tasks;

public class MyTask implements Runnable {
    private final String threadName;

    public MyTask(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + threadName+ ", " + "State: Running" + "Time: " + System.currentTimeMillis()/1000 +"s");
        try {
            // Giả lập việc xử lý tác vụ mất khoảng 2 giây để thực hiện
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread: " + threadName + ", " + "State: Finish");
    }
}
