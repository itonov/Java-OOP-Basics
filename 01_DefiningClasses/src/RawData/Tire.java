package RawData;

public class Tire {
    private int age;
    private double pressure;

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public double getPressure() {
        return pressure;
    }
}
