package itsInTheBlood.cells;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private Cell[][] cells;
    private int cellsCount;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[this.rows][this.cols];
    }

    public String getId() {
        return this.id;
    }

    public void activate() {
        if (this.cellsCount > 1) {
            Cell currentCell = null;
            for (int i = 0; i < this.cells.length; i++) {
                for (int j = 0; j < this.cells[i].length; j++) {
                    if (hasNextCell(i, j)) {
                        if (this.cells[i][j] != null && currentCell == null) {
                            currentCell = this.cells[i][j];
                        } else if (this.cells[i][j] == null && currentCell != null){
                            this.cells[i][j] = currentCell;
                            this.cells[currentCell.getPositionRow()][currentCell.getPositionCol()] = null;
                            currentCell.setPositionRow(i);
                            currentCell.setPositionCol(j);
                        } else if (this.cells[i][j] != null && currentCell != null){
                            Cell counterCell = this.cells[i][j];
                            switch (currentCell.getType()) {
                                case "BloodCell":
                                    currentCell.setHealth(currentCell.getHealth() + counterCell.getHealth());
                                    currentCell.setPositionRow(i);
                                    currentCell.setPositionCol(j);
                                    this.cells[counterCell.getPositionRow()][counterCell.getPositionCol()].setDestroyed(true);
                                    this.cellsCount--;
                                    break;
                                case "Microbe":
                                    int attackIndex = 1;
                                    while (true) {
                                        if (currentCell.getHealth() <= 0 || counterCell.getHealth() <= 0) {
                                            if (currentCell.getHealth() <= 0) {
                                                this.cells[currentCell.getPositionRow()][currentCell.getPositionCol()].setDestroyed(true);
                                                currentCell = counterCell;
                                                currentCell.setPositionRow(i);
                                                currentCell.setPositionCol(j);
                                            } else if (counterCell.getHealth() <= 0) {
                                                this.cells[counterCell.getPositionRow()][counterCell.getPositionCol()].setDestroyed(true);
                                                currentCell.setPositionRow(i);
                                                currentCell.setPositionCol(j);
                                            }
                                            this.cellsCount--;
                                            break;
                                        }
                                        if (attackIndex % 2 != 0) {
                                            counterCell.setHealth(counterCell.getHealth() - currentCell.calcEnergy());
                                            attackIndex++;
                                        } else {
                                            currentCell.setHealth(currentCell.getHealth() - counterCell.calcEnergy());
                                            attackIndex++;
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean hasNextCell(int row, int col) {
        for (int i = row; i < this.cells.length; i++) {
            for (int j = col; j < this.cells[i].length; j++) {
                if (this.cells[i][j] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addCell(Cell cell) {
        int neededRow = cell.getPositionRow();
        int neededCol = cell.getPositionCol();
        this.cells[neededRow][neededCol] = cell;
        this.cellsCount++;
    }

    public int getCellsCount() {
        return this.cellsCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("----Cluster %s", this.id));
        for (Cell[] row : this.cells) {
            for (Cell cell : row) {
                if (cell != null && !cell.isDestroyed()) {
                    sb.append(System.lineSeparator()).append(cell.toString());
                }
            }
        }
        return sb.toString();
    }
}
