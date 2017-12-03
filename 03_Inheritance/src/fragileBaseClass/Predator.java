package fragileBaseClass;

public class Predator extends Animal{
    private int health;

    public void feed(Food food) {
        super.eat(food);
        this.health++;
    }

    public int getHealth() {
        return this.health;
    }
}
