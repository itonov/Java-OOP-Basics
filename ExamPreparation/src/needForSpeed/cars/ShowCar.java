package needForSpeed.cars;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    public void addStars(int stars) {
        this.stars += stars;
    }

    @Override
    public boolean setHasAppliedForRace(boolean isInRace) {
        return isInRace;
    }

    @Override
    public void addTuning(int tuneIndex) {
        super.setHorsepower(super.getHorsepower() + tuneIndex);
        super.setSuspension(super.getSuspension() + (tuneIndex / 2));
    }

    @Override
    public int calculateOverallPerformance() {
        return (super.getHorsepower() / super.getAcceleration()) + (super.getSuspension() + super.getDurability());
    }

    @Override
    public int calculateEnginePerformance() {
        return super.getHorsepower() / super.getAcceleration();
    }

    @Override
    public int calculateSuspensionPerformance() {
        return super.getSuspension() + super.getDurability();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getBrand()).append(" ").append(super.getModel()).append(" ").append(super.getYearOfProduction())
                .append(System.lineSeparator()).append(this.getHorsepower()).append(" HP, 100 m/h in ")
                .append(super.getAcceleration()).append(" s").append(System.lineSeparator())
                .append(super.getSuspension()).append(" Suspension force, ").append(super.getDurability())
                .append(" Durability").append(System.lineSeparator()).append(this.stars).append(" *");
        return sb.toString();
    }
}
