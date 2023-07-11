package com.javarush.games.minigames.mini06;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Диалоговые окна
*/

public class MessageGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        showMessageDialog(Color.BLACK,"Вы выиграли",Color.GREEN,80);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        showMessageDialog(Color.YELLOW,"Вы проиграли",Color.RED,80);
    }
}
