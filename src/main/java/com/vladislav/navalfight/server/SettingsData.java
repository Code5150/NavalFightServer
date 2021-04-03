package com.vladislav.navalfight.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettingsData implements Serializable {
    private int size;
    private int shots;
    private int ships1;
    private int ships2;
    private int ships3;
    private int ships4;
}
