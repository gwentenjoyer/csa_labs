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
        Train[] trainsWithDestinationAndTime = haveDestinationAndAfterDateTime(trains, "New York", LocalDateTime.of(2001, 9, 11, 17, 30));
        for (int i = 0; i < trainsWithDestinationAndTime.length; i++) {
            System.out.println(trains[i]);
        }
        Train[] trainsWithDestinationAndGeneralCars = haveDestinationAndHaveGeneralCars(trains, "Lviv");
        for (int i = 0; i < trainsWithDestinationAndGeneralCars.length; i++) {
            System.out.println(trains[i]);
        }
    }
    public static Train[] haveDestination(Train[] trains, String dest){
        if(trains == null){
            throw new NullPointerException();
        }
        ArrayList<Train> haveDest = new ArrayList<>();
        for (int i = 0; i < trains.length; i++) {
            if(trains[i].getDestination().equals(dest)){
                haveDest.add(trains[i]);
            }
        }
        Train[] result = new Train[haveDest.size()];
        return haveDest.toArray(result);
    }
    public static Train[] haveDestinationAndAfterDateTime(Train[] trains, String dest, LocalDateTime time){
//        ArrayList<Train> arrayList = new ArrayList<>(Arrays.stream(haveDestination(trains, dest)).toList());
        ArrayList<Train> arrayList = new ArrayList<>();
        for (Train tr:
                trains) {
            if(tr.getDepartureTime().isAfter(time)){
                arrayList.add(tr);
            }
        }
        Train[] result = new Train[arrayList.size()];
        return arrayList.toArray(result);
    }
    public static Train[] haveDestinationAndHaveGeneralCars(Train[] trains, String dest){
        ArrayList<Train> arrayList = new ArrayList<>();
        for (Train tr:
                trains) {
            if(tr.getRailcarsNumber(RailcarType.GENERAL) > 0){
                arrayList.add(tr);
            }
        }

        Train[] result = new Train[arrayList.size()];
        return arrayList.toArray(result);
    }
}