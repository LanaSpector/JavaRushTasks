package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void start(String threadName) {
        Thread newThread = new Thread(new TaskManipulator(), threadName);
        thread = newThread;
        newThread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
