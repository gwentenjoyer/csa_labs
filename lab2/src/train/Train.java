package train;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Train {
    private String destination;
    private int trainNumber;
    private LocalDateTime departureTime;

    private Map<RailcarType, Integer> railcars;

    public Train() {
        this.railcars = new HashMap<>();
    }

    public Train(String destination, int trainNumber, LocalDateTime departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.railcars = new HashMap<>();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setRailcarNumber(RailcarType type, int number) {
        this.railcars.put(type, Integer.valueOf(number));
    }

    public void setRailcars(Map<RailcarType, Integer> railcars) {
        this.railcars = railcars;
    }
    public Integer getRailcarsNumber(RailcarType type){
        return this.railcars.get(type);
    }
    public Map<RailcarType, Integer> getRailcars() {
        return railcars;
    }


    public static Train createTrain(){
        Train train = new Train();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        System.out.println("Enter destination: ");
        train.setDestination(scanner.nextLine());
        System.out.println("Enter train number: ");
        train.setTrainNumber(scanner.nextInt());
        // Consuming "\n" character
        scanner.nextLine();
        System.out.println("Enter departure time date in format HH:mm dd-MM-yyyy: ");
        train.setDepartureTime(LocalDateTime.parse(scanner.nextLine(), formatter));
        System.out.println("Set number of general cars: ");
        train.setRailcarNumber(RailcarType.GENERAL, scanner.nextInt());
        System.out.println("Set number of couple cars: ");
        train.setRailcarNumber(RailcarType.COUPE, scanner.nextInt());
        System.out.println("Set number of plazcart cars: ");
        train.setRailcarNumber(RailcarType.PLATZKART, scanner.nextInt());
        System.out.println("Set number of luxury cars: ");
        train.setRailcarNumber(RailcarType.LUXURY, scanner.nextInt());
        return train;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        stringBuilder.append(String.format("Destination: %s\nTrain number: %s\nDeparture time: %s\n",
                this.destination, this.trainNumber, this.departureTime.format(dateTimeFormatter)));

        for (Map.Entry<RailcarType, Integer> entry:
             this.railcars.entrySet()) {
            stringBuilder.append(String.format("%s : %s\n", entry.getKey(), entry.getValue().toString()));
        }
        return stringBuilder.toString();
    }
}
