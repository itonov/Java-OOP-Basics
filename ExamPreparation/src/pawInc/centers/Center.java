package pawInc.centers;

import pawInc.animals.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Center {
    private String name;
    private List<Animal> storedAnimals;

    protected Center(String name) {
        this.name = name;
        this.storedAnimals = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(this.storedAnimals);
    }

    public void removeAnimals(List<Animal> animals) {
        this.storedAnimals.removeAll(animals);
    }

    public void register(Animal animal) {
        this.storedAnimals.add(animal);
    }

    public void registerAll(List<Animal> animals) {
        this.storedAnimals.addAll(animals);
    }
}
