package systemSplit.models.hardware;

public class PowerHardwareComponent extends HardwareComponent {
    public PowerHardwareComponent(String name, int capacity, int memory) {
        super(name, "HardwareComponent", capacity, memory);
    }

    @Override
    void setCapacity(int capacity) {
        super.setCapacity(capacity - ((capacity * 3) / 4));
    }

    @Override
    void setMemory(int memory) {
        super.setMemory(memory + ((memory * 3) / 4));
    }
}
