package PizzaCalories;

public class Topping {
    private String type;
    private int weight;

    Topping(String type, int weight) {
        setType(type);
        setWeight(weight);
    }

    private void setType(String type) {
        if (!type.equals("Meat") && !type.equals("Veggies") && !type.equals("Cheese") && !type.equals("Sauce")) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.type));
        }
        this.weight = weight;
    }

    double calculateCalories() {
        double initialCalories = 2 * this.weight;
        double modifier = 0.0;
        switch (this.type) {
            case "Meat":
                modifier = 1.2;
                break;
            case "Veggies":
                modifier = 0.8;
                break;
            case "Cheese":
                modifier = 1.1;
                break;
            case "Sauce":
                modifier = 0.9;
                break;
            default:
                break;
        }

        return initialCalories * modifier;
    }
}
