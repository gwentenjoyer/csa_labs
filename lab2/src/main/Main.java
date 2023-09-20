package main;

import train.RailcarType;
import train.Train;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){
        Train[] trains = arrayMaker(6);
        Train[] trainsWithDestinationAndTime = Main.haveDestinationAndAfterDateTime(trains, "New York", LocalDateTime.of(2001, 9, 11, 17, 30));
        for (int i = 0; i < trainsWithDestinationAndTime.length; i++) {
        }
        for (Train train:
                trainsWithDestinationAndTime) {
            System.out.println(train);
        }
        Train[] trainsWithDestinationAndGeneralCars = Main.haveDestinationAndHaveGeneralCars(trains, "Lviv");
        for (Train train:
                trainsWithDestinationAndGeneralCars) {
            System.out.println(train);
        }
    }

    public static Train[] arrayMaker(int count){
        Train[] trains = new Train[count];
        for (int i = 0; i < trains.length; i++) {
            trains[i] = new Train();
            trains[i].setDestination("Lviv");
            trains[i].setTrainNumber(42);
            trains[i].setDepartureTime(LocalDateTime.of(2023 + i, 9, 20, 17, (40 + i * 5) % 60));
            trains[i].setRailcarNumber(RailcarType.GENERAL, 10 + i);
            trains[i].setRailcarNumber(RailcarType.COUPE, 14 + i);
            trains[i].setRailcarNumber(RailcarType.PLATZKART, 8 + i);
            trains[i].setRailcarNumber(RailcarType.LUXURY, 1 + i);
        }
        return trains;
    }
    public static Train[] haveDestination(Train[] trains, String dest){
        if(trains == null){
            throw new IllegalArgumentException();
        }
        List<Train> haveDest = new ArrayList<>();
        for (int i = 0; i < trains.length; i++) {
            if(trains[i].getDestination().equals(dest)){
                haveDest.add(trains[i]);
            }
        }
        Train[] result = new Train[haveDest.size()];
        return haveDest.toArray(result);
    }
    public static Train[] haveDestinationAndAfterDateTime(Train[] trains, String dest, LocalDateTime time){
        Train[] trainsWithDestination = Main.haveDestination(trains, dest);
        List<Train> arrayList = new ArrayList<>();
        for (Train tr:
                trainsWithDestination) {
            if(tr.getDepartureTime().isAfter(time)){
                arrayList.add(tr);
            }
        }
        Train[] result = new Train[arrayList.size()];
        return arrayList.toArray(result);
    }
    public static Train[] haveDestinationAndHaveGeneralCars(Train[] trains, String dest){
        Train[] trainsWithDestination = Main.haveDestination(trains, dest);
        List<Train> arrayList = new ArrayList<>();
        for (Train tr:
                trainsWithDestination) {
            if(tr.getRailcarsNumber(RailcarType.GENERAL) > 0){
                arrayList.add(tr);
            }
        }
        Train[] result = new Train[arrayList.size()];
        return arrayList.toArray(result);
    }

}