package needForSpeed;

import needForSpeed.cars.PerformanceCar;
import needForSpeed.cars.ShowCar;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Garage {
    private Map<Integer, PerformanceCar> parkedPerformanceCars;
    private Map<Integer, ShowCar> parkedShowCars;

    Garage() {
        this.parkedPerformanceCars = new HashMap<>();
        this.parkedShowCars = new HashMap<>();
    }

    void parkPerformanceCar(int carId, PerformanceCar car) {
        this.parkedPerformanceCars.put(carId, car);
    }

    void parkShowCar(int carId, ShowCar car) {
        this.parkedShowCars.put(carId, car);
    }

    Map<Integer, PerformanceCar> getParkedPerformanceCars() {
        return Collections.unmodifiableMap(this.parkedPerformanceCars);
    }

    Map<Integer, ShowCar> getParkedShowCars() {
        return Collections.unmodifiableMap(this.parkedShowCars);
    }

    void unparkPerformanceCar(int carId) {
        this.parkedPerformanceCars.remove(carId);
    }

    void unparkShowCar(int carId) {
        this.parkedShowCars.remove(carId);
    }

    void tunePerformanceCars(int tuneIndex, String addOn) {
        for (Map.Entry<Integer, PerformanceCar> car : this.parkedPerformanceCars.entrySet()) {
            car.getValue().addTuning(tuneIndex);
            car.getValue().addAddOn(addOn);
        }
        for (Map.Entry<Integer, ShowCar> car : this.parkedShowCars.entrySet()) {
            car.getValue().addTuning(tuneIndex);
            car.getValue().addStars(tuneIndex);
        }
    }
}
