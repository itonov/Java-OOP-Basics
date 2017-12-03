package pawInc;

import pawInc.animals.Animal;
import pawInc.animals.Cat;
import pawInc.animals.Dog;
import pawInc.centers.AdoptionCenter;
import pawInc.centers.CleansingCenter;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager {
    private HashMap<String, CleansingCenter> cleansingCenters;
    private HashMap<String, AdoptionCenter> adoptionCenters;

    private List<Animal> adoptedAnimals;
    private List<Animal> cleansedAnimals;

    public AnimalCenterManager() {
        this.cleansingCenters = new HashMap<>();
        this.adoptionCenters = new HashMap<>();
        this.adoptedAnimals = new ArrayList<>();
        this.cleansedAnimals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        this.cleansingCenters.put(name, new CleansingCenter(name));
    }

    public void registerAdoptionCenter(String name) {
        this.adoptionCenters.put(name, new AdoptionCenter(name));
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = new Dog(name, age, learnedCommands, adoptionCenterName);
        this.adoptionCenters.get(adoptionCenterName).register(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = new Cat(name, age, intelligenceCoefficient, adoptionCenterName);
        this.adoptionCenters.get(adoptionCenterName).register(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        this.adoptionCenters.get(adoptionCenterName).sendForCleansing(this.cleansingCenters.get(cleansingCenterName));
    }

    public void cleanse(String cleansingCenterName) {
        List<Animal> cleansed = this.cleansingCenters.get(cleansingCenterName).cleanse();

        for (Animal animal : cleansed) {
            this.adoptionCenters.get(animal.getAdoptionCenter()).register(animal);
        }
        this.cleansedAnimals.addAll(cleansed);
    }

    public void adopt(String adoptionCenterName) {
        List<Animal> adopted = this.adoptionCenters.get(adoptionCenterName).adopt();
        this.adoptedAnimals.addAll(adopted);
    }

    public void printStatistics() {
        this.adoptedAnimals.sort(Comparator.comparing(Animal::getName));
        this.cleansedAnimals.sort(Comparator.comparing(Animal::getName));
        StringBuilder sb = new StringBuilder();
        sb.append("Paw Incorporative Regular Statistics").append(System.lineSeparator())
                .append("Adoption Centers: ").append(this.adoptionCenters.size()).append(System.lineSeparator())
                .append("Cleansing Centers: ").append(this.cleansingCenters.size()).append(System.lineSeparator())
                .append("Adopted Animals: ");
        if (this.adoptedAnimals.isEmpty()) {
            sb.append("None");
        } else {
            for (int i = 0; i < adoptedAnimals.size(); i++) {
                if (i + 1 == adoptedAnimals.size()) {
                    sb.append(adoptedAnimals.get(i).getName());
                } else {
                    sb.append(adoptedAnimals.get(i).getName()).append(", ");
                }
            }
        }

        sb.append(System.lineSeparator()).append("Cleansed Animals: ");
        if (this.cleansedAnimals.isEmpty()) {
            sb.append("None");
        } else {
            for (int i = 0; i < cleansedAnimals.size(); i++) {
                if (i + 1 == cleansedAnimals.size()) {
                    sb.append(cleansedAnimals.get(i).getName());
                } else {
                    sb.append(cleansedAnimals.get(i).getName()).append(", ");
                }
            }
        }
        sb.append(System.lineSeparator()).append("Animals Awaiting Adoption: ");
        int animalsForAdoptionCount = 0;
        for (Map.Entry<String, AdoptionCenter> center : adoptionCenters.entrySet()) {
            animalsForAdoptionCount += center.getValue().getAnimals().stream()
                    .filter(Animal::isCleansed)
                    .collect(Collectors.toList()).size();
        }
        sb.append(animalsForAdoptionCount).append(System.lineSeparator()).append("Animals Awaiting Cleansing: ");
        int animalsForCleansingCount = 0;
        for (Map.Entry<String, CleansingCenter> center : cleansingCenters.entrySet()) {
            animalsForCleansingCount += center.getValue().getAnimals().size();
        }
        sb.append(animalsForCleansingCount);

        System.out.println(sb.toString());
    }
}
