package com.pragatiplusplus.tictactoe.ai;

import android.view.View;

import com.pragatiplusplus.tictactoe.ui.view.TTTView;

/**
 * Created by Pragati on 7/30/2015.
 */
public class EasyLevel extends absLevel {

    private int[][] preferredRows = {{1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 2}, {0, 1}, {1, 0}, {1, 2}, {2, 1}};



    @Override
    public int[] getMove(TTTView[][] TTTButton) {
        for (int[] temp : preferredRows) {
            if (TTTButton[temp[0]][temp[1]].getState() == TTTView.State.EMPTY)
                return temp;
        }

        return new int[0];
    }
}
