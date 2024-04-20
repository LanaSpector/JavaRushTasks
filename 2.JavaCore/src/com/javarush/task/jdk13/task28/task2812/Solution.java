package com.javarush.task.jdk13.task28.task2812;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/* 
ShutdownNow!
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        IntStream.range(1,11).mapToObj(index->(Runnable)()->doExpensiveOperation(index)).forEach(executor::submit);
        List<Runnable> runnables = executor.shutdownNow();
        Thread.sleep(100);
        runnables.forEach(System.out::println);

    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
