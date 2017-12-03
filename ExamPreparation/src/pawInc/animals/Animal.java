package pawInc.animals;

public abstract class Animal {

    private String name;
    private int age;
    private boolean isCleansed;
    private String adoptionCenter;

    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.isCleansed = false;
    }

    protected Animal(String name, int age, String adoptionCenter) {
        this(name, age);
        this.adoptionCenter = adoptionCenter;
    }

    public void cleanse() {
        this.isCleansed = true;
    }

    public boolean isCleansed() {
        return this.isCleansed;
    }

    public String getName() {
        return this.name;
    }

    public String getAdoptionCenter() {
        return this.adoptionCenter;
    }
}
