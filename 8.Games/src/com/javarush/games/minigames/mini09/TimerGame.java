package com.javarush.games.minigames.mini09;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Таймер
*/

public class TimerGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);
        setTurnTimer(1000);
    }

    @Override
    public void onTurn(int n) {
        setCellNumber(1,1,n);
            for(int x=0;x<3;x++) {
                for(int y=0;y<3;y++) {
                    if(n%2==0) {
                    setCellColor(x,y,Color.GREEN);
                    } else {
                        setCellColor(x,y,Color.ORANGE);
                    }
                }
            }
        
        
    }
}
