package OpinionPoll;

public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "No name";
        this.age = 1;
    }

    public Person(int age) {
        this();
        this.age = age;
    }

    public Person(String name, int age) {
        this(age);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
