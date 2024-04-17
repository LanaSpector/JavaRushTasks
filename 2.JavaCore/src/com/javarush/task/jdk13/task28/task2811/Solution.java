package com.javarush.task.jdk13.task28.task2811;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/* 
Знакомство с Executors
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
//        for (int i = 1; i <= 20; i++) {
//            int finalI = i;
//            pool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    doExpensiveOperation(finalI);
//                }
//            });
//        }
        IntStream.range(1, 21).mapToObj(i -> (Runnable) () -> doExpensiveOperation(i)).forEach(pool::submit);
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

    }

    private static void doExpensiveOperation(int localID) {
        System.out.println(Thread.currentThread().getName() + ", localID=" + localID);
    }
}
