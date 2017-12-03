package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingType;
    private int weight;

    Dough(String flourType, String bakingType, int weight) {
        setFlourType(flourType);
        this.bakingType = bakingType;
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in range [1..200].");
        }
        this.weight = weight;
    }

    double calculateCalories() {
        double initialCalories = 2 * this.weight;
        double flourModifier = 0.0;
        switch (this.flourType) {
            case "White":
                flourModifier = 1.5;
                break;
            case "Wholegrain":
                flourModifier = 1.0;
                break;
            default:
                break;
        }

        double bakingTypeModifier = 0.0;
        switch (this.bakingType) {
            case "Crispy":
                bakingTypeModifier = 0.9;
                break;
            case "Chewy":
                bakingTypeModifier = 1.1;
                break;
            case "Homemade":
                bakingTypeModifier = 1.0;
                break;
            default:
                break;
        }

        return initialCalories * flourModifier * bakingTypeModifier;
    }
}
