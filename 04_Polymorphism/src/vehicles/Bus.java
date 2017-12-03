package vehicles;

public class Bus extends Vehicle {

    public Bus(double fuel, double fuelConsumption, double tankCapacity) {
        super(fuel, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        if (super.getPeople()) {
            super.setFuelConsumption(super.getFuelConsumption() + 1.4);
        }
        double neededFuel = distance * super.getFuelConsumption();

        if (neededFuel > super.getCurrentFuel()) {
            throw new IllegalStateException("Bus needs refueling");
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
