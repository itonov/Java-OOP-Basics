package itsInTheBlood.cells.bloodCells;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    @Override
    public int calcEnergy() {
        return (super.getHealth() + this.size) * 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("--------Health: %d | Size: %d | Energy: %d", super.getHealth(), this.size, this.calcEnergy()));
        return sb.toString();
    }
}
