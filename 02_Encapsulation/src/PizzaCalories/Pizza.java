package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    Pizza(String name, int numberOfToppings) {
        setName(name);
        setNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.length() > 15 || name.trim().isEmpty() || name.isEmpty()) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    void setDough(Dough dough) {
        this.dough = dough;
    }

    void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    double calculateCalories() {
        double doughCalories = this.dough.calculateCalories();
        double toppingCalories = 0.0;
        for (Topping topping : this.toppings) {
            toppingCalories += topping.calculateCalories();
        }

        return doughCalories + toppingCalories;
    }

    public String getName() {
        return this.name;
    }
}
