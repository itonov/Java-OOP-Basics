package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCars = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] inputParams = reader.readLine().split(" ");
            String model = inputParams[0];
            Engine carEngine = new Engine(Integer.parseInt(inputParams[1]), Integer.parseInt(inputParams[2]));
            Cargo cargo = new Cargo(Integer.parseInt(inputParams[3]), inputParams[4]);
            Tire firstTire = new Tire(Double.parseDouble(inputParams[5]), Integer.parseInt(inputParams[6]));
            Tire secondTire = new Tire(Double.parseDouble(inputParams[7]), Integer.parseInt(inputParams[8]));
            Tire thirdTire = new Tire(Double.parseDouble(inputParams[9]), Integer.parseInt(inputParams[10]));
            Tire fourthTire = new Tire(Double.parseDouble(inputParams[11]), Integer.parseInt(inputParams[12]));
            List<Tire> carTires = new ArrayList<>();
            carTires.add(firstTire);
            carTires.add(secondTire);
            carTires.add(thirdTire);
            carTires.add(fourthTire);
            Car newCar = new Car(model, carEngine, cargo, carTires);
            cars.add(newCar);
        }

        String neededCargoType = reader.readLine();

        switch (neededCargoType) {
            case "fragile":
                printCarsWithFragileCargo(cars);
                break;
            case "flamable":
                printCarsWithFlammableCargo(cars);
                break;
            default:
                break;
        }
    }

    private static void printCarsWithFlammableCargo(List<Car> cars) {
        for (Car car : cars) {
            if (car.getCargo().getType().equals("flamable") && car.getEngine().getPower() > 250) {
                System.out.println(car.getModel());
            }
        }
    }

    private static void printCarsWithFragileCargo(List<Car> cars) {
        for (Car car : cars) {
            if (car.getCargo().getType().equals("fragile")) {
                List<Tire> currentTires = car.getTires();
                for (Tire tire : currentTires) {
                    if (tire.getPressure() < 1.0) {
                        System.out.println(car.getModel());
                        break;
                    }
                }
            }
        }
    }
}
