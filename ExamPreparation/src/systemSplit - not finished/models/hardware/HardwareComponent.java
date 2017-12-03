package systemSplit.models.hardware;

import systemSplit.models.Component;
import systemSplit.models.software.SoftwareComponent;

import java.util.HashMap;
import java.util.Map;

public abstract class HardwareComponent extends Component {
    private Map<String, SoftwareComponent> components;
    private int capacity;
    private int memory;

    HardwareComponent(String name, String type, int capacity, int memory) {
        super(name, type);
        this.capacity = capacity;
        this.memory = memory;
        this.components = new HashMap<>();
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent){
        this.components.put(softwareComponent.getName(), softwareComponent);
    }

    void setCapacity(int capacity){
        this.capacity = capacity;
    }

    void setMemory(int memory) {
        this.memory = memory;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getMemory() {
        return this.memory;
    }
}
