package com.javarush.task.pro.task12.task1223;

public class TransportShip {
    public Integer speed;
    public Integer acceleration;
    public Passenger[] passengers;
    public OnBoardSystem onBoardSystem = new OnBoardSystem();

    public class OnBoardSystem {
        public Integer calculateJumpTime(Integer distance) {
            double finalSpeed = Math.sqrt(distance*2*acceleration + speed*speed);
            double time = (finalSpeed-speed)/acceleration;

            return (int) time;
        }
    }
}
