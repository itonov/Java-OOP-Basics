package needForSpeed.races;

import needForSpeed.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public abstract String startRace();

    int calculateFirstPrize() {
        return (this.prizePool * 50) / 100;
    }

    int calculateSecondPrize() {
        return (this.prizePool * 30) / 100;
    }

    int calculateThirdPrize() {
        return (this.prizePool * 20) / 100;
    }

    String getRoute() {
        return this.route;
    }

    int getLength() {
        return this.length;
    }

    public void addParticipant(Car participant) {
        this.participants.add(participant);
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }
}
