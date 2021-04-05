package com.vladislav.navalfight.server;

import java.util.Random;

public class FieldGenerator {
    private static final Random random = new Random();
    private static int size = 0;

    public static CellData[][] generate(SettingsData settingsData) {
        size = settingsData.getSize();
        var result = new CellData[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                result[i][j] = new CellData(i, j, false, false);
            }
        }
        for (int i = 0; i < settingsData.getShips4(); i++) setShip(4, result);
        for (int i = 0; i < settingsData.getShips3(); i++) setShip(3, result);
        for (int i = 0; i < settingsData.getShips2(); i++) setShip(2, result);
        for (int i = 0; i < settingsData.getShips1(); i++) setShip(1, result);
        return result;
    }

    private static void setShip(int shipSize, CellData[][] field) {
        while (true) {
            //Положение корабля: 0 - вертикальная, 1 - горизонтальная
            int orient = random.nextInt(2);

            int posX = random.nextInt(size);
            int posY = random.nextInt(size);
            try {
                var target = new Target();
                if (orient == 0) {
                    if ((posY - shipSize + 1) < 0) throw new IndexOutOfBoundsException("Корабль за границами карты");
                    for (int i = (posY-shipSize); i <= posY + 1; i++ ){
                        for (int j = (posX-1); j <= posX + 1; j++ ){
                            //Если окружающие клетки за границами поля, то их не проверяем
                            if (i >= 0 && j >= 0 && i < size && j < size) {
                                if (field[i][j].isTarget()) throw new Exception("Клетка занята");
                            }
                        }
                    }
                    for (int i = (posY-shipSize+1); i < posY + 1; i++) {
                        field[i][posX].setTarget(true);
                        target.addCell(field[i][posX]);
                    }
                } else {
                    if ((posX + shipSize - 1) >= size) throw new IndexOutOfBoundsException("Корабль за границами карты");
                    for (int i = posY - 1; i <= posY + 1; i++ ){
                        for (int j = (posX-1); j <= posX + shipSize; j++ ){
                            //Если окружающие клетки за границами поля, то их не проверяем
                            if (i >= 0 && j >= 0 && i < size && j < size) {
                                if (field[i][j].isTarget()) throw new Exception("Клетка занята");
                            }
                        }
                    }
                    for (int j = posX; j < posX + shipSize; j++) {
                        field[posY][j].setTarget(true);
                        target.addCell(field[posY][j]);
                    }
                }
                FightCalculationsImpl.addTarget(target);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void printField(CellData[][] field) {
        for(var row: field) {
            for (var col: row) {
                if (col.isTarget()) System.out.print("[]");
                else System.out.print("~~");
            }
            System.out.println();
        }
    }
}
