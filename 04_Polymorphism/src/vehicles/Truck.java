package vehicles;

public class Truck extends Vehicle {
    public Truck(double fuel, double fuelConsumption, double tankCapacity) {
        super(fuel, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.6);
    }

    @Override
    protected void drive(double distance) {
        double neededFuel = distance * super.getFuelConsumption();
        if (neededFuel > super.getCurrentFuel()) {
            throw new IllegalStateException("Truck needs refueling");
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
        double truckFuel = super.getCurrentFuel() + amount * 0.95;
        super.setCurrentFuel(truckFuel);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), super.getCurrentFuel());
    }
}
