package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        State state = thread.getState();
        System.out.println(state);
        while (true) {
            State innerState = thread.getState();
            if (innerState != state) {
                System.out.println(innerState);
                state = innerState;
            }
            if (innerState == State.TERMINATED) {
                return;
            }
        }
    }
}
