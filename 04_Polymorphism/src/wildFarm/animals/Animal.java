package wildFarm.animals;

import wildFarm.food.Food;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    Animal(String animalName, String animalType, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
    }

    String getAnimalName() {
        return this.animalName;
    }

    double getAnimalWeight() {
        return this.animalWeight;
    }

    public String getAnimalType() {
        return this.animalType;
    }

    int getFoodEaten() {
        return this.foodEaten;
    }

    void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract String makeSound();

    public abstract void eat(Food food);

    @Override
    public abstract String toString();
}
