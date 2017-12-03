package wildFarm;

import wildFarm.animals.*;
import wildFarm.food.Food;
import wildFarm.food.Meat;
import wildFarm.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Food food = null;
        Animal animal = null;
        while (!"end".equalsIgnoreCase(input)) {
            String[] animalTokens = input.split(" ");
            String[] foodTokens = reader.readLine().split(" ");
            String animalType = animalTokens[0];
            String animalName = animalTokens[1];
            String animalWeight = animalTokens[2];
            String animalRegion = animalTokens[3];
            switch (animalType) {
                case "Cat":
                    String breed = animalTokens[4];
                    animal = new Cat(animalName, animalType, Double.parseDouble(animalWeight), animalRegion, breed);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalType, Double.parseDouble(animalWeight), animalRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalType, Double.parseDouble(animalWeight), animalRegion);
                    break;
                case "Mouse":
                    animal = new Mouse(animalName, animalType, Double.parseDouble(animalWeight), animalRegion);
                    break;
            }
            String foodType = foodTokens[0];
            int foodQuantity = Integer.parseInt(foodTokens[1]);
            switch (foodType) {
                case "Vegetable":
                    food = new Vegetable(foodQuantity);
                    break;
                case "Meat":
                    food = new Meat(foodQuantity);
                    break;
            }

            input = reader.readLine();
        }

        System.out.println(animal.makeSound());
        try {
            animal.eat(food);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        System.out.println(animal.toString());
    }
}
