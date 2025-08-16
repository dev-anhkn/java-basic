package org.example.thread_simple;

public class ThreadSimple extends Thread {
    @Override
    public void run() {
        System.out.println("This is a thread.");
    }
}