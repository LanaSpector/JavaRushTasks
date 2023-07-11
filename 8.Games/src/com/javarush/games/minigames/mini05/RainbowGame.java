package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    public void initialize() {
        setScreenSize(10,7);
        for(int i=0;i<10;i++) {
            for(int j=0;j<7;j++) {
                switch(j) {
                    case 0: setCellColor(i,j,Color.RED);
                    break;
                    case 1: setCellColor(i,j,Color.ORANGE);
                    break;
                    case 2: setCellColor(i,j,Color.YELLOW);
                    break;
                    case 3: setCellColor(i,j,Color.GREEN);
                    break;
                    case 4: setCellColor(i,j,Color.BLUE);
                    break;
                    case 5: setCellColor(i,j,Color.INDIGO);
                    break;
                    case 6: setCellColor(i,j,Color.VIOLET);
                }
                
            }
        }
    }
}
