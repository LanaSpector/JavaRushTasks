package com.javarush.task.jdk13.task41.task4112;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bowling {
    private final Queue<Track> tracks;
    private final Queue<PairOfShoes> shoesShelf;

    public Bowling(int tracksNumber) {
//        tracks = new ConcurrentLinkedDeque<>();
//        shoesShelf = new ConcurrentLinkedDeque<>();

//        for (int i = 1; i <= tracksNumber; i++) {
//            tracks.offer(new Track(i));
//        }

//        for (int i = 0; i < 50; i++) {
//            int randomNumber = ThreadLocalRandom.current().nextInt(38, 46);
//            shoesShelf.offer(new PairOfShoes(randomNumber));
//        }
//        IntStream.rangeClosed(1, tracksNumber).forEach(i -> tracks.offer(new Track(i)));
        tracks = IntStream.rangeClosed(1, tracksNumber)
                .mapToObj(Track::new)
                .collect(Collectors.toCollection(ConcurrentLinkedDeque::new));

        shoesShelf = IntStream.range(0, 50)
                .mapToObj(i -> ThreadLocalRandom.current().nextInt(38, 46))
                .map(PairOfShoes::new)
                .collect(Collectors.toCollection(ConcurrentLinkedDeque::new));

    }

    public synchronized Track acquireTrack() {
        if (tracks.isEmpty()) {
            return null;
        }
        Track newTrack = tracks.poll();
        int numb = 100 - tracks.size() * 10;
        newTrack.setPrice(numb);
        return newTrack;
    }

    public synchronized void releaseTrack(Track track) {
        System.out.printf("C дорожки №%d сняли бронь\n", track.getNumber());
        tracks.offer(track);
    }

    public synchronized Set<PairOfShoes> acquireShoes(int number) {
        if (shoesShelf.size() < number) {
            return null;
        }
        Set<PairOfShoes> shoes = new HashSet<>();
        for (int i = 0; i < number; i++) {
            PairOfShoes removed = shoesShelf.poll();
            shoes.add(removed);
        }
        return shoes;
    }

    public synchronized void releaseShoes(Set<PairOfShoes> shoes) {
        System.out.printf("В гардероб вернули %d пар обуви\n", shoes.size());
        shoesShelf.addAll(shoes);
    }
}
