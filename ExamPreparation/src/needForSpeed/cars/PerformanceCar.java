package needForSpeed.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    public void addAddOn(String addOn) {
        this.addOns.add(addOn);
    }

    @Override
    public void addTuning(int tuneIndex) {
        super.setHorsepower(super.getHorsepower() + tuneIndex);
        super.setSuspension(super.getSuspension() + (tuneIndex / 2));
    }

    @Override
    protected void setHorsepower(int horsepower) {
        super.setHorsepower(horsepower + ((horsepower * 50) / 100));
    }

    @Override
    protected void setSuspension(int suspension) {
        super.setSuspension(suspension - ((suspension * 25) / 100));
    }

    @Override
    public boolean setHasAppliedForRace(boolean isInRace) {
        return isInRace;
    }

    @Override
    public int calculateOverallPerformance() {
        return ((super.getHorsepower() / super.getAcceleration()) + (super.getSuspension() + super.getDurability()));
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
                .append(" Durability").append(System.lineSeparator());
        if (this.addOns.isEmpty()) {
            sb.append("Add-ons: None");
        } else {
            sb.append("Add-ons: ").append(String.join(", ", addOns));
        }

        return sb.toString();
    }
}
