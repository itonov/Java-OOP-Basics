package vehicles;

public class Car extends Vehicle {
    public Car(double fuel, double fuelConsumption, double tankCapacity) {
        super(fuel, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 0.9);
    }

    @Override
    public void drive(double distance) {
        double neededFuel = distance * super.getFuelConsumption();
        if (neededFuel > super.getCurrentFuel()) {
            throw new IllegalStateException("Car needs refueling");
        }
        super.setCurrentFuel(super.getCurrentFuel() - neededFuel);
    }

    @Override
    public void refuel(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (amount + super.getCurrentFuel() > super.getTankCapacity()) {
            throw new IllegalStateException("Cannot fit fuel in tank");
        }
        super.setCurrentFuel(super.getCurrentFuel() + amount);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), super.getCurrentFuel());
    }
}
