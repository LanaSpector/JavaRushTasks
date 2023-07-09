package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                int number = getRandomNumber(10);
                boolean isMine = number == 7;
                if(isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y,isMine);
                setCellColor(x, y, Color.BLUE);
            }
        }
    }
}

