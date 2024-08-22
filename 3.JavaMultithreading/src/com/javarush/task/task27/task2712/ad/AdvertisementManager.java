//package com.javarush.task.task27.task2712.ad;
//
//import com.javarush.task.task27.task2712.ConsoleHelper;
//
//import java.util.Collections;
//import java.util.Comparator;
//
//public class AdvertisementManager {
//    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
//    private int timeSeconds;
//
//    public AdvertisementManager(int timeSeconds) {
//        this.timeSeconds = timeSeconds;
//    }
//
//    public void processVideos() {
//        if (storage.list().isEmpty()) {
//            throw new NoVideoAvailableException();
//        }
//
////        Collections.sort(storage.list(), new Comparator<Advertisement>() {
////            @Override
////            public int compare(Advertisement o1, Advertisement o2) {
////                if (o1.getAmountPerOneDisplaying() > o2.getAmountPerOneDisplaying()) {
////                    return -1;
////                }
////                if (o1.getAmountPerOneDisplaying() < o2.getAmountPerOneDisplaying()) {
////                    return 1;
////                }
////                if (o1.getAmountPerOneDisplaying() / o1.getDuration() > o2.getAmountPerOneDisplaying() / o2.getDuration()) {
////                    return 1;
////                }
//////                if (o1.getAmountPerOneDisplaying() / o1.getDuration() < o2.getAmountPerOneDisplaying() / o2.getDuration()) {
//////                    return -1;
//////                }
//////                return 0;
//////            }
//////        });
////    }
////
////    public void
////}
