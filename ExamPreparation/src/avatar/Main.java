package avatar;

import avatar.Monuments.*;
import avatar.benders.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<AirBender> airBenders = new ArrayList<>();
        List<EarthBender> earthBenders = new ArrayList<>();
        List<FireBender> fireBenders = new ArrayList<>();
        List<WaterBender> waterBenders = new ArrayList<>();

        List<AirMonument> airMonuments = new ArrayList<>();
        List<EarthMonument> earthMonuments = new ArrayList<>();
        List<FireMonument> fireMonuments = new ArrayList<>();
        List<WaterMonument> waterMonuments = new ArrayList<>();

        List<String> warIssuers = new ArrayList<>();
        String input = reader.readLine();
        while (!"quit".equalsIgnoreCase(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Bender":
                    addBender(tokens, airBenders, earthBenders, fireBenders, waterBenders);
                    break;
                case "Monument":
                    addMonument(tokens, airMonuments, earthMonuments, fireMonuments, waterMonuments);
                    break;
                case "Status":
                    printStatus(tokens[1], airBenders, earthBenders, fireBenders, waterBenders,
                            airMonuments, earthMonuments, fireMonuments, waterMonuments);
                    break;
                case "War":
                    String nation = tokens[1];
                    warIssuers.add(nation);
                    startWar(airBenders, earthBenders, fireBenders, waterBenders,
                            airMonuments, earthMonuments, fireMonuments, waterMonuments);
                    break;
            }

            input = reader.readLine();
        }

        int warCounter = 1;
        for (String nation : warIssuers) {
            System.out.println("War " + warCounter + " issued by " + nation);
            warCounter++;
        }
    }

    private static void startWar(List<AirBender> airBenders,
                                 List<EarthBender> earthBenders,
                                 List<FireBender> fireBenders,
                                 List<WaterBender> waterBenders,
                                 List<AirMonument> airMonuments,
                                 List<EarthMonument> earthMonuments,
                                 List<FireMonument> fireMonuments,
                                 List<WaterMonument> waterMonuments) {
        Long totalAirPower = 0L;
        for (AirBender bender : airBenders) {
            totalAirPower += (long)bender.calculatePower();
        }

        Long totalEarthPower = 0L;
        for (EarthBender bender : earthBenders) {
            totalEarthPower += (long)bender.calculatePower();
        }

        Long totalFirePower = 0L;
        for (FireBender bender : fireBenders) {
            totalFirePower += (long)bender.calculatePower();
        }

        Long totalWaterPower = 0L;
        for (WaterBender bender : waterBenders) {
            totalWaterPower += (long)bender.calculatePower();
        }

        Long airMonumentSum = 0L;
        for (AirMonument monument : airMonuments) {
            airMonumentSum += monument.getPower();
        }

        Long earthMonumentSum = 0L;
        for (EarthMonument monument : earthMonuments) {
            earthMonumentSum += monument.getPower();
        }

        Long fireMonumentSum = 0L;
        for (FireMonument monument : fireMonuments) {
            fireMonumentSum += monument.getPower();
        }

        Long waterMonumentSum = 0L;
        for (WaterMonument monument : waterMonuments) {
            waterMonumentSum += monument.getPower();
        }

        totalAirPower += ((totalAirPower / 100) * airMonumentSum);
        totalEarthPower += ((totalEarthPower / 100) * earthMonumentSum);
        totalFirePower += ((totalFirePower / 100) * fireMonumentSum);
        totalWaterPower += ((totalWaterPower / 100) * waterMonumentSum);

        if (totalAirPower > totalEarthPower && totalAirPower > totalFirePower && totalAirPower > totalWaterPower) {
            earthBenders.clear();
            earthMonuments.clear();

            fireBenders.clear();
            fireMonuments.clear();

            waterBenders.clear();
            waterMonuments.clear();
        } else if (totalEarthPower > totalAirPower && totalEarthPower > totalFirePower && totalAirPower > totalWaterPower) {
            airBenders.clear();
            airMonuments.clear();

            fireBenders.clear();
            fireMonuments.clear();

            waterBenders.clear();
            waterMonuments.clear();
        } else if (totalFirePower > totalAirPower && totalFirePower > totalEarthPower && totalFirePower > totalWaterPower) {
            airBenders.clear();
            airMonuments.clear();

            earthBenders.clear();
            earthMonuments.clear();

            waterBenders.clear();
            waterMonuments.clear();
        } else {
            airBenders.clear();
            airMonuments.clear();

            fireBenders.clear();
            fireMonuments.clear();

            earthBenders.clear();
            earthMonuments.clear();
        }
    }

    private static void printStatus(String type,
                                    List<AirBender> airBenders,
                                    List<EarthBender> earthBenders,
                                    List<FireBender> fireBenders,
                                    List<WaterBender> waterBenders,
                                    List<AirMonument> airMonuments,
                                    List<EarthMonument> earthMonuments,
                                    List<FireMonument> fireMonuments,
                                    List<WaterMonument> waterMonuments) {
        System.out.println(type + " Nation");
        switch (type) {
            case "Air":
                if (airBenders.isEmpty()) {
                    System.out.println("Benders: None");
                } else {
                    System.out.println("Benders:");
                    for (Bender bender : airBenders) {
                        System.out.println(bender.toString());
                    }
                }
                if (airMonuments.isEmpty()) {
                    System.out.println("Monuments: None");
                } else {
                    System.out.println("Monuments: ");
                    for (Monument monument : airMonuments) {
                        System.out.println("###" + monument.toString());
                    }
                }
                break;
            case "Earth":
                if (earthBenders.isEmpty()) {
                    System.out.println("Benders: None");
                } else {
                    System.out.println("Benders:");
                    for (Bender bender : earthBenders) {
                        System.out.println(bender.toString());
                    }
                }
                if (earthMonuments.isEmpty()) {
                    System.out.println("Monuments: None");
                } else {
                    System.out.println("Monuments: ");
                    for (Monument monument : earthMonuments) {
                        System.out.println("###" + monument.toString());
                    }
                }
                break;
            case "Water":
                if (waterBenders.isEmpty()) {
                    System.out.println("Benders: None");
                } else {
                    System.out.println("Benders:");
                    for (Bender bender : waterBenders) {
                        System.out.println(bender.toString());
                    }
                }
                if (waterMonuments.isEmpty()) {
                    System.out.println("Monuments: None");
                } else {
                    System.out.println("Monuments:");
                    for (Monument monument : waterMonuments) {
                        System.out.println("###" + monument.toString());
                    }
                }
                break;
            case "Fire":
                if (fireBenders.isEmpty()) {
                    System.out.println("Benders: None");
                } else {
                    System.out.println("Benders:");
                    for (Bender bender : fireBenders) {
                        System.out.println(bender.toString());
                    }
                }
                if (fireMonuments.isEmpty()) {
                    System.out.println("Monuments: None");
                } else {
                    System.out.println("Monuments:");
                    for (Monument monument : fireMonuments) {
                        System.out.println("###" + monument.toString());
                    }
                }
                break;
        }
    }

    private static void addMonument(String[] tokens,
                                    List<AirMonument> airMonuments,
                                    List<EarthMonument> earthMonuments,
                                    List<FireMonument> fireMonuments,
                                    List<WaterMonument> waterMonuments) {
        String type = tokens[1];
        String name = tokens[2];
        int affinity = Integer.parseInt(tokens[3]);
        switch (type) {
            case "Air":
                airMonuments.add(new AirMonument(name, affinity));
                break;
            case "Earth":
                earthMonuments.add(new EarthMonument(name, affinity));
                break;
            case "Fire":
                fireMonuments.add(new FireMonument(name, affinity));
                break;
            case "Water":
                waterMonuments.add(new WaterMonument(name, affinity));
                break;
        }
    }

    private static void addBender(String[] tokens,
                                  List<AirBender> airBenders,
                                  List<EarthBender> earthBenders,
                                  List<FireBender> fireBenders,
                                  List<WaterBender> waterBenders) {
        String type = tokens[1];
        String name = tokens[2];
        int power = Integer.parseInt(tokens[3]);
        double secondPower = Double.parseDouble(tokens[4]);
        switch (type) {
            case "Air":
                airBenders.add(new AirBender(name, power, secondPower));
                break;
            case "Earth":
                earthBenders.add(new EarthBender(name, power, secondPower));
                break;
            case "Fire":
                fireBenders.add(new FireBender(name, power, secondPower));
                break;
            case "Water":
                waterBenders.add(new WaterBender(name, power, secondPower));
                break;
        }
    }
}
