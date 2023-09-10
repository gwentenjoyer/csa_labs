package train;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.Map;

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

    public Map<RailcarType, Integer> getRailcars() {
        return railcars;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yy");
        stringBuilder.append(String.format("Destination: %s\nTrain number: %s\nDeparture time: %s\n",
                this.destination, this.trainNumber, this.departureTime.format(dateTimeFormatter)));

        for (Map.Entry<RailcarType, Integer> entry:
             this.railcars.entrySet()) {
            stringBuilder.append(String.format("%s : %s\n", entry.getKey(), entry.getValue().toString()));
        }
        return stringBuilder.toString();
    }
}
