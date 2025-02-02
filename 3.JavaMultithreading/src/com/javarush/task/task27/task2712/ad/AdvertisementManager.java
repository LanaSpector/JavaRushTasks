package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdvertisementManager {
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    private List<Advertisement> bestVideos;
    private int bestDuration = Integer.MAX_VALUE;
    private long bestAmount;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }


    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException("");
        }
        List<Advertisement> videoList = storage.list().stream()
                .filter(video -> video.getDuration() <= timeSeconds)
                .filter(video -> video.getAmountPerOneDisplaying() > 0)
                .collect(Collectors.toList());
        makeFullAdvertisements(videoList);

        bestVideos.sort(Comparator.comparingLong(Advertisement::getAmountPerOneDisplaying)
                .thenComparingInt(Advertisement::getDuration)
                .reversed());

        for (Advertisement bestVideo : bestVideos) {
            ConsoleHelper.writeMessage(bestVideo.toString());
            bestVideo.revalidate();
        }
    }

    private void makeFullAdvertisements(List<Advertisement> advertisementList) {
        if (!advertisementList.isEmpty()) {
            updateBestAdvertisements(advertisementList);
        }

        for (int i = 0; i < advertisementList.size(); i++) {
            List<Advertisement> newVideoList = new ArrayList<>(advertisementList);
            newVideoList.remove(i);
            makeFullAdvertisements(newVideoList);
        }
    }

    private void updateBestAdvertisements(List<Advertisement> videolist) {
        long amount = calculateAmount(videolist);
        int duration = calculateDuration(videolist);

        if (bestVideos == null && duration <= timeSeconds) {
            updateBestFields(videolist, duration, amount);
        } else if (duration <= timeSeconds) {
            if (amount > bestAmount) {
                updateBestFields(videolist, duration, amount);
            }
            if (amount == bestAmount) {
                if(duration > bestDuration) {
                    updateBestFields(videolist, duration, amount);
                }
                if(duration == bestDuration && videolist.size() < bestVideos.size()) {
                    updateBestFields(videolist, duration, amount);
                }
            }
        }
    }

    private void updateBestFields(List<Advertisement> videolist, int duration, long amount) {
        bestVideos = videolist;
        bestDuration = duration;
        bestAmount = amount;
    }

    private long calculateAmount(List<Advertisement> videolist) {
        return videolist.stream()
                .mapToLong(Advertisement::getAmountPerOneDisplaying)
                .sum();
    }

    private int calculateDuration(List<Advertisement> videolist) {
        return videolist.stream()
                .mapToInt(Advertisement::getDuration)
                .sum();
    }
}
