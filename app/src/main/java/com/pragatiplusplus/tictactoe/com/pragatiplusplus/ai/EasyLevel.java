package com.pragatiplusplus.tictactoe.com.pragatiplusplus.ai;

import android.view.View;

import com.pragatiplusplus.tictactoe.ui.view.TTTView;

/**
 * Created by Pragati on 7/30/2015.
 */
public class EasyLevel {

  private  int[][] preferredRows = {{1,1} ,{0,0},{0,2},{2,0},{2,2} ,{0, 1}, {1, 0}, {1, 2}, {2, 1}};
    int turn = 0;
    TTTView tempButton[][];
    public void getChance(View v)
    {
        TTTView play = (TTTView)findViewById(v.getId());
        if(turn == 0)
        {
            setValue(play , TTTView.State.CROSS , firstPlayer);
            turn++;
        }

        else if(turn == 1)
        {
            int val[]= move();
            setValue(tempButton[val[0]][val[1]] , TTTView.State.CIRCLE , secondPlayer);
            turn ++;
        }

    }

    public int[] move()
    {
        for(int[] temp : preferredRows)
        {
            if(tempButton[temp[0]][temp[1]].getState() == TTTView.State.EMPTY)
                return temp;

        }
        return null;
    }
}
