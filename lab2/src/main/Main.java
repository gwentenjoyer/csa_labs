package main;

import train.RailcarType;
import train.Train;

import java.time.LocalDateTime;

public class Main {
    Train[] train;
    public static void main(String args[]){
        Train train = new Train("Lviv", 234, LocalDateTime.of(2023, 11, 15, 17, 45));
        train.setRailcarNumber(RailcarType.GENERAL, 22);
        train.setRailcarNumber(RailcarType.COUPE, 11);
        System.out.println(train);

    }
}
