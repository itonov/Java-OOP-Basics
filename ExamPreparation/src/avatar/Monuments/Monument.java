package avatar.Monuments;

public abstract class Monument {
    private String name;

    public Monument(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    protected abstract int getPower();
}
