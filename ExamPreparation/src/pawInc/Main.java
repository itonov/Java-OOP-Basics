package pawInc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AnimalCenterManager acm = new AnimalCenterManager();
        String input = reader.readLine();

        while (!"paw paw pawah".equalsIgnoreCase(input)) {
            String[] tokens = input.split(" \\| ");
            String command = tokens[0];
            switch (command) {
                case "RegisterAdoptionCenter":
                    String name = tokens[1];
                    acm.registerAdoptionCenter(name);
                    break;
                case "RegisterCleansingCenter":
                    name = tokens[1];
                    acm.registerCleansingCenter(name);
                    break;
                case "RegisterDog":
                    name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    int learnedCommands = Integer.parseInt(tokens[3]);
                    String adoptionCenterName = tokens[4];
                    acm.registerDog(name, age, learnedCommands, adoptionCenterName);
                    break;
                case "RegisterCat":
                    name = tokens[1];
                    age = Integer.parseInt(tokens[2]);
                    int intelligenceCoefficient = Integer.parseInt(tokens[3]);
                    adoptionCenterName = tokens[4];
                    acm.registerCat(name, age, intelligenceCoefficient, adoptionCenterName);
                    break;
                case "SendForCleansing":
                    adoptionCenterName = tokens[1];
                    String cleansingCenterName = tokens[2];
                    acm.sendForCleansing(adoptionCenterName, cleansingCenterName);
                    break;
                case "Cleanse":
                    cleansingCenterName = tokens[1];
                    acm.cleanse(cleansingCenterName);
                    break;
                case "Adopt":
                    adoptionCenterName = tokens[1];
                    acm.adopt(adoptionCenterName);
                    break;
                default:
                    break;
            }
            input = reader.readLine();
        }
        acm.printStatistics();
    }
}
