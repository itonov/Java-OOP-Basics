package methodOverriding;

public class Square extends Rectangle {
    public Square(double side) {
        super(side);
    }

    @Override
    public Double area() {
        return this.sideA * this.sideA;
    }
}
