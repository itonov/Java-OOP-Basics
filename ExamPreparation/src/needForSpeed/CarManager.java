package needForSpeed;

import needForSpeed.cars.PerformanceCar;
import needForSpeed.cars.ShowCar;
import needForSpeed.races.CasualRace;
import needForSpeed.races.DragRace;
import needForSpeed.races.DriftRace;

import java.util.LinkedHashMap;
import java.util.Map;

class CarManager {
    private static Map<Integer, PerformanceCar> performanceCars = new LinkedHashMap<>();
    private static Map<Integer, ShowCar> showCars = new LinkedHashMap<>();
    private static Map<Integer, CasualRace> casualRaces = new LinkedHashMap<>();
    private static Map<Integer, DragRace> dragRaces = new LinkedHashMap<>();
    private static Map<Integer, DriftRace> driftRaces = new LinkedHashMap<>();
    private static Garage garage = new Garage();

    void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower,
                         int acceleration, int suspension, int durability){
        switch (type) {
            case "Performance":
                CarManager.performanceCars.put(id, new PerformanceCar(
                        brand, model, yearOfProduction, horsepower, acceleration, suspension, durability
                ));
                break;
            case "Show":
                CarManager.showCars.put(id, new ShowCar(
                        brand, model, yearOfProduction, horsepower, acceleration, suspension, durability
                ));
                break;
        }
    }

    String check(int id) {
        if (performanceCars.containsKey(id)) {
            return performanceCars.get(id).toString();
        } else {
            return showCars.get(id).toString();
        }
    }

    void open(int id, String type, int length, String route, int prizePool) {
        switch (type) {
            case "Casual":
                casualRaces.put(id, new CasualRace(length, route, prizePool));
                break;
            case "Drag":
                dragRaces.put(id, new DragRace(length, route, prizePool));
                break;
            case "Drift":
                driftRaces.put(id, new DriftRace(length, route, prizePool));
                break;
        }
    }

    void participate(int carId, int raceId) {
        if (casualRaces.containsKey(raceId)) {
            if (performanceCars.containsKey(carId) && !performanceCars.get(carId).isParked()) {
                casualRaces.get(raceId).addParticipant(performanceCars.get(carId));
                performanceCars.get(carId).setHasAppliedForRace(true);
            } else if (showCars.containsKey(carId) && !showCars.get(carId).isParked()) {
                casualRaces.get(raceId).addParticipant(showCars.get(carId));
                showCars.get(carId).setHasAppliedForRace(true);
            }
        } else if (dragRaces.containsKey(raceId)) {
            if (performanceCars.containsKey(carId) && !performanceCars.get(carId).isParked()) {
                dragRaces.get(raceId).addParticipant(performanceCars.get(carId));
                performanceCars.get(carId).setHasAppliedForRace(true);
            } else if (showCars.containsKey(carId) && !showCars.get(carId).isParked()) {
                dragRaces.get(raceId).addParticipant(showCars.get(carId));
                showCars.get(carId).setHasAppliedForRace(true);
            }
        } else {
            if (performanceCars.containsKey(carId) && !performanceCars.get(carId).isParked()) {
                driftRaces.get(raceId).addParticipant(performanceCars.get(carId));
                performanceCars.get(carId).setHasAppliedForRace(true);
            } else if (showCars.containsKey(carId) && !showCars.get(carId).isParked()) {
                driftRaces.get(raceId).addParticipant(showCars.get(carId));
                showCars.get(carId).setHasAppliedForRace(true);
            }
        }
    }

    String start(int raceId) {
        String result;
        if (casualRaces.containsKey(raceId)) {
            if (casualRaces.get(raceId).getParticipants().isEmpty()) {
                return "Cannot start the race with zero participants.";
            }
            result = casualRaces.get(raceId).startRace();
            casualRaces.remove(raceId);
        } else if (dragRaces.containsKey(raceId)) {
            if (dragRaces.get(raceId).getParticipants().isEmpty()) {
                return "Cannot start the race with zero participants.";
            }
            result = dragRaces.get(raceId).startRace();
            dragRaces.remove(raceId);
        } else {
            if (driftRaces.get(raceId).getParticipants().isEmpty()) {
                return "Cannot start the race with zero participants.";
            }
            result = driftRaces.get(raceId).startRace();
            driftRaces.remove(raceId);
        }
        return result;
    }

    void park(int carId) {
        if (performanceCars.containsKey(carId)) {
            if (!performanceCars.get(carId).isAppliedForRace()) {
                garage.parkPerformanceCar(carId, performanceCars.get(carId));
                performanceCars.get(carId).setParked(true);
            }
        } else {
            if (!showCars.get(carId).isAppliedForRace()) {
                garage.parkShowCar(carId, showCars.get(carId));
                showCars.get(carId).setParked(true);
            }
        }
    }

    void unpark(int carId) {
        if (garage.getParkedPerformanceCars().containsKey(carId)) {
            garage.unparkPerformanceCar(carId);
            performanceCars.get(carId).setParked(false);
        } else {
            garage.unparkShowCar(carId);
            showCars.get(carId).setParked(false);
        }
    }

    void tune(int tuneIndex, String addOn) {
        if (!garage.getParkedPerformanceCars().isEmpty() || !garage.getParkedShowCars().isEmpty()) {
            garage.tunePerformanceCars(tuneIndex, addOn);
        }
    }
}
