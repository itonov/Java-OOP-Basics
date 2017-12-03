package systemSplit.models.software;

public class ExpressSoftwareComponent extends SoftwareComponent {
    public ExpressSoftwareComponent(String name, int capacity, int memory) {
        super(name, "ExpressSoftware", capacity, memory);
    }

    @Override
    void setCapacityConsumption(int capacityConsumption) {
        super.setCapacityConsumption(capacityConsumption);
    }

    @Override
    void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption * 2);
    }
}
