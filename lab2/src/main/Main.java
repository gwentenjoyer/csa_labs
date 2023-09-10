package main;

import train.Train;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
//    private static Train[] trains;
    public static void main(String args[]){
        Train[] trains = new Train[1];
        for (int i = 0; i < trains.length; i++) {
            trains[i] = Train.createTrain();
        }
        Train[] trainsWithDestination = haveDestination(trains, "Lviv");
        Train[] trainsWithDestinationAndTime = haveDestinationAndAfterDateTime(trains, "New York", LocalDateTime.of(2001, 9, 11, 17, 30));

        for (int i = 0; i < trainsWithDestination.length; i++) {
            System.out.println(trains[i]);
        }
        for (int i = 0; i < trainsWithDestinationAndTime.length; i++) {
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
        ArrayList<Train> arrayList = new ArrayList<>(Arrays.stream(haveDestination(trains, dest)).toList());
        for (Train tr:
             arrayList) {
            if(!tr.getDepartureTime().isAfter(time)){
                arrayList.remove(tr);
            }
        }
        Train[] result = new Train[arrayList.size()];
        return arrayList.toArray(result);
    }
}