package itsInTheBlood;

import itsInTheBlood.cells.Cluster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HealthManager healthManager = new HealthManager();
        String input = reader.readLine();

        while (!"BEER IS COMING".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "checkCondition":
                    String name = tokens[1];
                    if (healthManager.getOrganisms().containsKey(name)) {
                        System.out.println(healthManager.checkCondition(name));
                    }
                    break;
                case "createOrganism":
                    name = tokens[1];
                    System.out.println(healthManager.createOrganism(name));
                    break;
                case "addCluster":
                    name = tokens[1];
                    String id = tokens[2];
                    int rows = Integer.parseInt(tokens[3]);
                    int cols = Integer.parseInt(tokens[4]);
                    boolean uniqueCluster = true;
                    if (healthManager.getOrganisms().containsKey(name)) {
                        List<Cluster> currentClusters = healthManager.getOrganisms().get(name).getClusters();
                        for (Cluster cluster : currentClusters) {
                            if (cluster.getId().equalsIgnoreCase(id)) {
                                uniqueCluster = false;
                                break;
                            }
                        }
                        if (uniqueCluster) {
                            System.out.println(healthManager.addCluster(name, id, rows, cols));
                        }
                    }
                    break;
                case "addCell":
                    name = tokens[1];
                    String clusterId = tokens[2];
                    String cellType = tokens[3];
                    String cellId = tokens[4];
                    int health = Integer.parseInt(tokens[5]);
                    int positionRow = Integer.parseInt(tokens[6]);
                    int positionCol = Integer.parseInt(tokens[7]);
                    int additionalProperty = Integer.parseInt(tokens[8]);
                    if (healthManager.getOrganisms().containsKey(name)) {
                        System.out.println(healthManager.addCell(name, clusterId, cellType, cellId, health, positionRow,
                                positionCol, additionalProperty));
                    }
                    break;
                case "activateCluster":
                    name = tokens[1];
                    if (healthManager.getOrganisms().containsKey(name)) {
                        System.out.println(healthManager.activateCluster(name));
                    }
                    break;
                default:
                    break;
            }

            input = reader.readLine();
        }
    }
}
