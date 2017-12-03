package ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    Product(String name, double cost) {
        setName(name);
        this.cost = cost;
    }

    String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    public double getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
