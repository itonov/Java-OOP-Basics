package needForSpeed.cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;
    private boolean hasAppliedForRace;
    private boolean isParked;

    public Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        setHorsepower(horsepower);
        this.acceleration = acceleration;
        setSuspension(suspension);
        this.durability = durability;
        this.hasAppliedForRace = false;
        this.isParked = false;
    }

    public boolean isParked() {
        return this.isParked;
    }

    public void setParked(boolean parked) {
        this.isParked = parked;
    }

    protected void setHorsepower(int horsepower){
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    int getYearOfProduction() {
        return this.yearOfProduction;
    }

    int getHorsepower() {
        return this.horsepower;
    }

    int getAcceleration() {
        return this.acceleration;
    }

    int getSuspension() {
        return this.suspension;
    }

    int getDurability() {
        return this.durability;
    }

    public boolean isAppliedForRace() {
        return this.hasAppliedForRace;
    }

    public abstract boolean setHasAppliedForRace(boolean isInRace);

    public abstract void addTuning(int tuneIndex);

    public abstract int calculateOverallPerformance();

    public abstract int calculateEnginePerformance();

    public abstract int calculateSuspensionPerformance();

    @Override
    public abstract String toString();
}
