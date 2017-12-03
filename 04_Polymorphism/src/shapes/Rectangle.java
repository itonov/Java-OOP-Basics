package shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 + (this.height + this.width);
    }

    @Override
    public double calculateArea() {
        return this.height * this.width;
    }
}
