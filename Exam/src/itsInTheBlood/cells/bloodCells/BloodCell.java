package itsInTheBlood.cells.bloodCells;

import itsInTheBlood.cells.Cell;

public abstract class BloodCell extends Cell {
    public BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public String getType() {
        return "BloodCell";
    }
}
