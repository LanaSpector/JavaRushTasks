package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/

public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() throws InterruptedException {
        if (lock.tryLock()) {
            try {
                actionIfLockIsFree();
            } catch (Exception e) {
                lock.unlock();
            }
        } else {
            actionIfLockIsBusy();
        }
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}
