package systemSplit.models.hardware;

public class HeavyHardwareComponent extends HardwareComponent {
    public HeavyHardwareComponent(String name, int capacity, int memory) {
        super(name, "HeavyHardware", capacity, memory);
    }

    @Override
    void setCapacity(int capacity) {
        super.setCapacity(capacity * 2);
    }

    @Override
    void setMemory(int memory) {
        super.setMemory(memory - (memory / 4));
    }
}
