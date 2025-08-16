package org.example.runable_simple;

public class Main {

    public static void main(String[] args) {
        RunnableSimple runnableSimple = new RunnableSimple();
        Thread thread = new Thread(runnableSimple);
        thread.start();
    }
}
