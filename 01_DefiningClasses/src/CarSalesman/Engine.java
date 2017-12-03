package CarSalesman;

public class Engine {
    private static final String DEFAULT_DISPLACEMENT = "n/a";
    private static final String DEFAULT_EFFICIENCY = "n/a";

    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = DEFAULT_DISPLACEMENT;
        this.efficiency = DEFAULT_EFFICIENCY;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format(" %s:%n    Power: %d%n    Displacement: %s%n    Efficiency: %s",
                this.model,
                this.power,
                this.displacement,
                this.efficiency);
    }
}
