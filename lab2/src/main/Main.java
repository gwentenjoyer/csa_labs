package main;

import train.RailcarType;
import train.Train;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        Train[] trains = new Train[1];
        for (int i = 0; i < trains.length; i++) {
            trains[i] = Train.createTrain();
        }

//        Train[] trainsWithDestination = haveDestination(trains, "Lviv");
//        for (int i = 0; i < trainsWithDestination.length; i++) {
//            System.out.println(trains[i]);
//        }
        Train[] trainsWithDestinationAndTime = Train.haveDestinationAndAfterDateTime(trains, "New York", LocalDateTime.of(2001, 9, 11, 17, 30));
        for (int i = 0; i < trainsWithDestinationAndTime.length; i++) {
            System.out.println(trains[i]);
        }
        Train[] trainsWithDestinationAndGeneralCars = Train.haveDestinationAndHaveGeneralCars(trains, "Lviv");
        for (int i = 0; i < trainsWithDestinationAndGeneralCars.length; i++) {
            System.out.println(trains[i]);
        }
    }

}