package com.vladislav.navalfight.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CellData implements Serializable {
    private int x;
    private int y;
    private boolean target = false;
    private boolean hit = false;
}
