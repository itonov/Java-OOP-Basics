package needForSpeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        CarManager carManager = new CarManager();
        while (!"cops are here".equalsIgnoreCase(input)){
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "register":
                    int id = Integer.parseInt(tokens[1]);
                    String type = tokens[2];
                    String brand = tokens[3];
                    String model = tokens[4];
                    int year = Integer.parseInt(tokens[5]);
                    int horsePower = Integer.parseInt(tokens[6]);
                    int acceleration = Integer.parseInt(tokens[7]);
                    int suspension = Integer.parseInt(tokens[8]);
                    int durability = Integer.parseInt(tokens[9]);
                    carManager.register(id, type, brand, model, year, horsePower, acceleration, suspension, durability);
                    break;
                case "open":
                    id = Integer.parseInt(tokens[1]);
                    type = tokens[2];
                    int length = Integer.parseInt(tokens[3]);
                    String route = tokens[4];
                    int prize = Integer.parseInt(tokens[5]);
                    carManager.open(id, type, length, route, prize);
                    break;
                case "participate":
                    int carId = Integer.parseInt(tokens[1]);
                    int raceId = Integer.parseInt(tokens[2]);
                    carManager.participate(carId, raceId);
                    break;
                case "check":
                    id = Integer.parseInt(tokens[1]);
                    System.out.println(carManager.check(id));
                    break;
                case "start":
                    raceId = Integer.parseInt(tokens[1]);
                    System.out.println(carManager.start(raceId));
                    break;
                case "park":
                    carId = Integer.parseInt(tokens[1]);
                    carManager.park(carId);
                    break;
                case "unpark":
                    carId = Integer.parseInt(tokens[1]);
                    carManager.unpark(carId);
                    break;
                case "tune":
                    int tuneIndex = Integer.parseInt(tokens[1]);
                    String addOn = tokens[2];
                    carManager.tune(tuneIndex, addOn);
                    break;
            }
            input = reader.readLine();
        }
    }
}
