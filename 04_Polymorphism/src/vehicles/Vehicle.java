package vehicles;

public abstract class Vehicle {
    private double currentFuel;
    private double fuelConsumption;
    private double tankCapacity;
    private boolean hasPeople;

    protected Vehicle(double currentFuel, double fuelConsumption, double tankCapacity) {
        setCurrentFuel(currentFuel);
        setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
        this.hasPeople = true;
    }

    boolean getPeople() {
        return this.hasPeople;
    }

    void removePeople() {
        this.hasPeople = false;
    }

    void addPeople() {
        this.hasPeople = true;
    }

    double getTankCapacity() {
        return this.tankCapacity;
    }

    void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    double getCurrentFuel() {
        return this.currentFuel;
    }

    double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected abstract void drive(double distance);

    protected abstract void refuel(double amount);
}
