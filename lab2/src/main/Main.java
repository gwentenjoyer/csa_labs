package main;

import train.Train;

import java.util.ArrayList;

public class Main {
//    private static Train[] trains;
    public static void main(String args[]){
//        Train train = new Train("Lviv", 234, LocalDateTime.of(2023, 11, 15, 17, 45));
        Train[] trains = new Train[2];
        for (int i = 0; i < trains.length; i++) {
            trains[i] = Train.createTrain();
        }
//        train.setRailcarNumber(RailcarType.GENERAL, 22);
//        train.setRailcarNumber(RailcarType.COUPE, 11);
        String destination = "Lviv";
        Train[] trainsWithDestination = haveDestination(trains, destination);
//        for (int i = 0; i < trains.length; i++) {
//            System.out.println(trains[i]);
//        }
        for (int i = 0; i < trainsWithDestination.length; i++) {
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
}