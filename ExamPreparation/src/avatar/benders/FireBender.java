package avatar.benders;

public class FireBender extends Bender {
    private double heatAggresion;

    public FireBender(String name, int power, double heatAggresion) {
        super(name, power);
        this.heatAggresion = heatAggresion;
    }

    public double calculatePower() {
        return super.getPower() * this.heatAggresion;
    }

    @Override
    public String toString() {
        return String.format("###Fire Bender: %s, Power: %d, Heat Aggression: %.2f",
                super.getName(),
                super.getPower(),
                this.heatAggresion);
    }
}
