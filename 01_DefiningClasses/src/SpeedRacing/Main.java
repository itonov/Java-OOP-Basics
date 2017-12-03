package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCars = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] inputParams = reader.readLine().split(" ");
            String carModel = inputParams[0];
            double fuelAmount = Double.parseDouble(inputParams[1]);
            double fuelCost = Double.parseDouble(inputParams[2]);
            Car newCar = new Car(carModel, fuelAmount, fuelCost);
            cars.add(newCar);
        }

        String inputDrive = reader.readLine();

        while (!"end".equalsIgnoreCase(inputDrive)) {
            String[] driveParams = inputDrive.split(" ");
            String modelToDrive = driveParams[1];
            int distanceToDrive = Integer.parseInt(driveParams[2]);
            for (Car car : cars) {
                if (car.getModel().equals(modelToDrive)) {
                    double maxDistance = car.getFuelAmount() / car.getFuelCostPerKm();
                    if (maxDistance < distanceToDrive) {
                        System.out.println("Insufficient fuel for the drive");
                        break;
                    } else {
                        double neededFuel = car.getFuelCostPerKm() * distanceToDrive;
                        double remainingFuel = car.getFuelAmount() - neededFuel;
                        car.setFuelAmount(remainingFuel);
                        int totalDistanceTravelled = car.getDistanceTravelled() + distanceToDrive;
                        car.setDistanceTravelled(totalDistanceTravelled);
                    }
                }
            }
            inputDrive = reader.readLine();
        }

        for (Car car : cars) {
            System.out.printf("%s %.2f %d%n", car.getModel(), car.getFuelAmount(), car.getDistanceTravelled());
        }
    }
}
