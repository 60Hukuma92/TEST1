package com.company;

public class Cell {
    private CellType cellType;
    private int lifetime;


    public Cell(CellType cellType, int lifetime) {
        this.cellType = cellType;
        this.lifetime = lifetime;
    }

    public Cell(CellType cellType) {
        this(cellType, 0);
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

}
