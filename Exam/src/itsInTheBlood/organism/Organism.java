package itsInTheBlood.organism;

import itsInTheBlood.cells.Cluster;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Organism {
    private String name;
    private LinkedList<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedList<>();
    }

    public void activateCluster(){
        Cluster clusterToActivate = this.clusters.get(0);
        this.clusters.remove(0);
        clusterToActivate.activate();
        this.clusters.add(clusterToActivate);
    }

    public void addCluster(Cluster cluster) {
        this.clusters.add(cluster);
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    @Override
    public String toString() {
        int totalCellsCount = 0;
        for (Cluster cluster : this.clusters) {
            totalCellsCount += cluster.getCellsCount();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Organism - %s", this.name)).append(System.lineSeparator())
                .append(String.format("--Clusters: %d", this.clusters.size())).append(System.lineSeparator())
                .append(String.format("--Cells: %d", totalCellsCount));
        for (int i = 0; i < this.clusters.size(); i++) {
            Cluster cluster = this.clusters.get(i);
            sb.append(System.lineSeparator()).append(cluster.toString());
        }

        return sb.toString();
    }
}
