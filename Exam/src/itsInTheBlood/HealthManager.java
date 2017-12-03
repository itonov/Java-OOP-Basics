package itsInTheBlood;

import itsInTheBlood.cells.Cell;
import itsInTheBlood.cells.Cluster;
import itsInTheBlood.cells.bloodCells.RedBloodCell;
import itsInTheBlood.cells.bloodCells.WhiteBloodCell;
import itsInTheBlood.cells.microbes.Bacteria;
import itsInTheBlood.cells.microbes.Fungi;
import itsInTheBlood.cells.microbes.Virus;
import itsInTheBlood.organism.Organism;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HealthManager {
    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new HashMap<>();
    }

    public Map<String, Organism> getOrganisms() {
        return Collections.unmodifiableMap(this.organisms);
    }

    public String checkCondition(String organismName) {
        return this.organisms.get(organismName).toString();
    }

    public String createOrganism(String name) {
        if (this.organisms.containsKey(name)) {
            return String.format("Organism %s already exists", name);
        }
        this.organisms.put(name, new Organism(name));
        return String.format("Created organism %s", name);
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        Cluster cluster = new Cluster(id, rows, cols);
        this.organisms.get(organismName).addCluster(cluster);
        return String.format("Organism %s: Created cluster %s", organismName, id);
    }

    public String addCell(String organismName,
                          String clusterId,
                          String cellType,
                          String cellId,
                          int health,
                          int positionRow,
                          int positionCol,
                          int additionalProperty) {
        Cell cell = null;
        switch (cellType) {
            case "RedBloodCell":
                cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "WhiteBloodCell":
                cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Bacteria":
                cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Fungi":
                cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Virus":
                cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                break;
        }
        List<Cluster> clusters = this.organisms.get(organismName).getClusters();
        for (Cluster cluster : clusters) {
            if (cluster.getId().equals(clusterId)) {
                cluster.addCell(cell);
                break;
            }
        }
        return String.format("Organism %s: Created cell %s in cluster %s", organismName, cellId, clusterId);
    }

    public String activateCluster(String organismName) {
        Cluster clusterToActivate = this.organisms.get(organismName).getClusters().get(0);
        String clusterId = clusterToActivate.getId();
        this.organisms.get(organismName).activateCluster();
        int remainingCellsCount = clusterToActivate.getCellsCount();

        return String.format("Organism %s: Activated cluster %s. Cells left: %d",
                organismName,
                clusterId,
                remainingCellsCount);
    }
}
