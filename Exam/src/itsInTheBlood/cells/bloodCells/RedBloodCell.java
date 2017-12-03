package itsInTheBlood.cells.bloodCells;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    @Override
    public int calcEnergy() {
        return super.getHealth() + this.velocity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("--------Health: %d | Velocity: %d | Energy: %d",
                super.getHealth(), this.velocity, this.calcEnergy()));
        return sb.toString();
    }
}
