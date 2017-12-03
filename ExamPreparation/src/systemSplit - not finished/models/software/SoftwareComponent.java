package systemSplit.models.software;

import systemSplit.models.Component;

public abstract class SoftwareComponent extends Component {
    private int capacityConsumption;
    private int memoryConsumption;

    SoftwareComponent(String name, String type, int capacity, int memory) {
        super(name, type);
        this.capacityConsumption = capacity;
        this.memoryConsumption = memory;
    }

    void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

    public int getCapacity() {
        return this.capacityConsumption;
    }

    public int getMemory() {
        return this.memoryConsumption;
    }
}
