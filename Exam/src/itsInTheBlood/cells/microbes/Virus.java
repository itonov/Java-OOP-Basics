package itsInTheBlood.cells.microbes;

public class Virus extends Microbe {

    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int calcEnergy() {
        return super.getHealth() + super.getVirulence();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("--------Health: %d | Virulence: %d | Energy: %d",
                super.getHealth(),
                super.getVirulence(),
                this.calcEnergy()));
        return sb.toString();
    }
}
