package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class VideoSelectedEventDataRow implements EventDataRow{

    private final List<Advertisement> optimalVideoSet;
    private final long amount;
    private final int totalDuration;
    private final Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }
}
