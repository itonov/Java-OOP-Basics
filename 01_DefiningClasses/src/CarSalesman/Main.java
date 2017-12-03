package CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int enginesNumber = Integer.parseInt(reader.readLine());
        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < enginesNumber; i++) {
            String[] inputParams = reader.readLine().split("\\s+");
            String engineModel = inputParams[0];
            int power = Integer.parseInt(inputParams[1]);
            Engine newEngine = new Engine(engineModel, power);
            switch (inputParams.length) {
                case 3:
                    if (inputParams[2].matches("\\d+")) {
                        newEngine.setDisplacement(inputParams[2]);
                    } else {
                        newEngine.setEfficiency(inputParams[2]);
                    }
                    break;
                case 4:
                    if (inputParams[2].matches("\\d+")) {
                        newEngine.setDisplacement(inputParams[2]);
                        newEngine.setEfficiency(inputParams[3]);
                    } else {
                        newEngine.setEfficiency(inputParams[2]);
                        newEngine.setDisplacement(inputParams[3]);
                    }
                    break;
                default:
                    break;
            }
            engines.add(newEngine);
        }

        int carsNumber = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsNumber; i++) {
            String[] inputParams = reader.readLine().split("\\s+");
            String carModel = inputParams[0];
            String engineModel = inputParams[1];
            Car newCar = null;
            for (Engine engine : engines) {
                if (engine.getModel().equals(engineModel)) {
                    newCar = new Car(carModel, engine);
                    break;
                }
            }

            switch (inputParams.length) {
                case 3:
                    if (inputParams[2].matches("\\d+")) {
                        newCar.setWeight(inputParams[2]);
                    } else {
                        newCar.setColor(inputParams[2]);
                    }
                    break;
                case 4:
                    if (inputParams[2].matches("\\d+")) {
                        newCar.setWeight(inputParams[2]);
                        newCar.setColor(inputParams[3]);
                    } else {
                        newCar.setColor(inputParams[2]);
                        newCar.setWeight(inputParams[3]);
                    }
                    break;
                default:
                    break;
            }
            cars.add(newCar);
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
