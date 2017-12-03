package needForSpeed.races;

import needForSpeed.cars.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CasualRace extends Race {
    private List<Car> winners;

    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
        this.winners = new ArrayList<>();
    }

    @Override
    public String startRace() {
        if (super.getParticipants().isEmpty()) {
            return "Cannot start the race with zero participants.";
        }
        this.winners = super.getParticipants();
        StringBuilder sb = new StringBuilder();
        sb.append(super.getRoute()).append(" - ").append(super.getLength()).append(System.lineSeparator());
        if (this.winners.size() >= 3) {
            this.winners = this.winners.stream()
                    .sorted(Comparator.comparingInt(Car::calculateOverallPerformance).reversed())
                    .limit(3)
                    .collect(Collectors.toList());
            Car firstCar = this.winners.get(0);
            Car secondCar = this.winners.get(1);
            Car thirdCar = this.winners.get(2);

            sb.append("1. ").append(firstCar.getBrand()).append(" ").append(firstCar.getModel()).append(" ")
                    .append(firstCar.calculateOverallPerformance()).append("PP - $").append(super.calculateFirstPrize())
                    .append(System.lineSeparator())
                    .append("2. ").append(secondCar.getBrand()).append(" ").append(secondCar.getModel()).append(" ")
                    .append(secondCar.calculateOverallPerformance()).append("PP - $").append(super.calculateSecondPrize())
                    .append(System.lineSeparator())
                    .append("3. ").append(thirdCar.getBrand()).append(" ").append(thirdCar.getModel()).append(" ")
                    .append(thirdCar.calculateOverallPerformance()).append("PP - $").append(super.calculateThirdPrize());
        } else {
            this.winners = this.winners.stream()
                    .sorted(Comparator.comparingInt(Car::calculateOverallPerformance).reversed())
                    .collect(Collectors.toList());
            if (this.winners.size() == 1) {
                Car winner = this.winners.get(0);
                sb.append("1. ").append(winner.getBrand()).append(" ").append(winner.getModel()).append(" ")
                        .append(winner.calculateOverallPerformance()).append("PP - $").append(super.calculateFirstPrize());
            } else {
                Car firstCar = this.winners.get(0);
                Car secondCar = this.winners.get(1);
                sb.append("1. ").append(firstCar.getBrand()).append(" ").append(firstCar.getModel()).append(" ")
                        .append(firstCar.calculateOverallPerformance()).append("PP - $").append(super.calculateFirstPrize())
                        .append(System.lineSeparator())
                        .append("2. ").append(secondCar.getBrand()).append(" ").append(secondCar.getModel()).append(" ")
                        .append(secondCar.calculateOverallPerformance()).append("PP - $").append(super.calculateSecondPrize());
            }
        }

        for (Car car : super.getParticipants()) {
            car.setHasAppliedForRace(false);
        }
        return sb.toString();
    }
}
