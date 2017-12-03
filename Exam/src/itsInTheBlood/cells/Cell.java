package itsInTheBlood.cells;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;
    private boolean destroyed;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
        this.destroyed = false;
    }

    public boolean isDestroyed() {
        return this.destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract String getType();

    public abstract int calcEnergy();

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]%n", this.id, this.positionRow, this.positionCol);
    }
}
