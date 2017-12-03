package wildFarm.animals;

public abstract class Mammal extends Animal {
    String livingRegion;

    Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    String getLivingRegion() {
        return this.livingRegion;
    }
}
