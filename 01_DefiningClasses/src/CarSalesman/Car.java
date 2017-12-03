package CarSalesman;

public class Car {
    private static final String DEFAULT_WEIGHT = "n/a";
    private static final String DEFAULT_COLOR = "n/a";

    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = DEFAULT_WEIGHT;
        this.color = DEFAULT_COLOR;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n %s%n  Weight: %s%n  Color: %s", this.model, this.engine.toString(), this.weight, this.color);
    }
}
