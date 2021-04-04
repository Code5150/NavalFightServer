package com.vladislav.navalfight.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Target {
    private TurnData[] ship;

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
