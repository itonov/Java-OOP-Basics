package methodOverriding;

public class Rectangle {
    protected double sideA;
    private double sideB;

    Rectangle(double sideA) {
        this.sideA = sideA;
    }

    Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Double area() {
        return this.sideA * this.sideB;
    }
}
