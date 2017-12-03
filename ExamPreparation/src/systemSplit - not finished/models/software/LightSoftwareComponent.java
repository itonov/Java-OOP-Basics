package systemSplit.models.software;

public class LightSoftwareComponent extends SoftwareComponent {
    public LightSoftwareComponent(String name, int capacity, int memory) {
        super(name, "LightSoftware", capacity, memory);
    }

    @Override
    void setCapacityConsumption(int capacityConsumption) {
        super.setCapacityConsumption(capacityConsumption + (capacityConsumption / 2));
    }

    @Override
    void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption - (memoryConsumption / 2));
    }
}
