package com.vladislav.navalfight.server;


import java.util.ArrayList;

public class Target {
    private final ArrayList<CellData> ship = new ArrayList<>();

    public void addCell(CellData cell) {
        ship.add(cell);
    }

    public boolean isDestroyed() {
        boolean result = true;
        for (var cell: ship) {
            if (!cell.isHit()) {
                result = false;
                break;
            }
        }
        return result;
    }
}
