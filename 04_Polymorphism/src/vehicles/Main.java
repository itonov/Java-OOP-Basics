package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carTokens = reader.readLine().split(" ");
        String[] truckTokens = reader.readLine().split(" ");
        String[] busTokens = reader.readLine().split(" ");
        int n = Integer.parseInt(reader.readLine());
        Map<String, Vehicle> vehicles = new HashMap<>();

        Vehicle car = new Car(Double.parseDouble(carTokens[1]),
                Double.parseDouble(carTokens[2]),
                Double.parseDouble(carTokens[3]));

        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]),
                Double.parseDouble(truckTokens[2]),
                Double.parseDouble(truckTokens[3]));

        Vehicle bus = new Bus(Double.parseDouble(busTokens[1]),
                Double.parseDouble(busTokens[2]),
                Double.parseDouble(busTokens[3]));

        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);
        while (n-- > 0) {
            String[] inputTokens = reader.readLine().split(" ");
            String action = inputTokens[0];
            String neededVehicle = inputTokens[1];
            double value = Double.parseDouble(inputTokens[2]);

            DecimalFormat df = new DecimalFormat("#.##");
            switch (action) {
                case "Drive":
                    try {
                        vehicles.get(neededVehicle).drive(value);
                        System.out.printf("%s travelled %s km%n", neededVehicle, df.format(value));
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
                    break;
                case "Refuel":
                    try {
                        vehicles.get(neededVehicle).refuel(value);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    vehicles.get("Bus").removePeople();
                    try {
                        vehicles.get("Bus").drive(value);
                        System.out.printf("%s travelled %s km%n", neededVehicle, df.format(value));
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
            }
        }

        System.out.println(vehicles.get("Car").toString());
        System.out.println(vehicles.get("Truck").toString());
        System.out.println(vehicles.get("Bus").toString());
    }
}
