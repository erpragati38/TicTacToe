package com.pragatiplusplus.tictactoe;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.pragatiplusplus.tictactoe.ui.view.TTTView;


public class PlayActivity extends ActionBarActivity {

    String firstPlayer;
    String secondPlayer;
    int turn = 0;
    private TTTView b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private TextView result;
    private int mCircleResId;
    private int mCrossResId;
    TTTView tempButton[][];

    /**
     * Create Buttons
     */
    public void createButton() {
        tempButton = new TTTView[3][3];
        tempButton[0][0] = (TTTView) findViewById(R.id.row1col1);
        setXYDrawable(tempButton[0][0]);
        tempButton[0][1] = (TTTView) findViewById(R.id.row1col2);
        setXYDrawable(tempButton[0][1]);
        tempButton[0][2] = (TTTView) findViewById(R.id.row1col3);
        setXYDrawable(tempButton[0][2]);
        tempButton[1][0] = (TTTView) findViewById(R.id.row2col1);
        setXYDrawable(tempButton[1][0]);
        tempButton[1][1] = (TTTView) findViewById(R.id.row2col2);
        setXYDrawable(tempButton[1][1]);
        tempButton[1][2] = (TTTView) findViewById(R.id.row2col3);
        setXYDrawable(tempButton[1][2]);
        tempButton[2][0] = (TTTView) findViewById(R.id.row3col1);
        setXYDrawable(tempButton[2][0]);
        tempButton[2][1] = (TTTView) findViewById(R.id.row3col2);
        setXYDrawable(tempButton[2][1]);
        tempButton[2][2] = (TTTView) findViewById(R.id.row3col3);
        setXYDrawable(tempButton[2][2]);

        result = (TextView) findViewById(R.id.output);
        newGame(result);
    }

    private void setXYDrawable(TTTView view) {
        view.setCircleDrawable(mCircleResId);
        view.setCrossDrawable(mCrossResId);
    }

    /**
     *
     * Checks Draw State
     */
    public boolean isDraw() {
        boolean flag = false;
        for(int index = 0 ; index < tempButton.length ; index++) {
            for (int count = 0; count < tempButton.length; count++) {
                if (tempButton[index][count].getState() == TTTView.State.EMPTY)
                    return false;
            }
        }
        return true;
}

    /**
     *
     *
     * Check Winner of the Game
     */
    public boolean isWinner(TTTView.State chance) {
      boolean flag = false;
        for(int index = 0 ; index < tempButton.length ; index++)
        {


           if((tempButton[index][0].getState()== chance)&& (tempButton[index][1].getState() == chance) && (tempButton[index][2].getState() == chance))
               return true;
        }

        for(int count = 0 ; count < tempButton.length ; count++)
        {


            if((tempButton[0][count].getState() == chance)&& (tempButton[1][count].getState() == chance) && (tempButton[2][count].getState() == chance))
                return  true;
        }

         if (tempButton[0][2].getState() == chance && tempButton[1][1].getState() == chance && tempButton[2][0].getState() == chance)
            flag = true;

        else if(tempButton[0][0].getState() == chance && tempButton[1][1].getState() == chance && tempButton[2][2].getState() == chance)
            flag = true;

        return flag;


    }

    /**
     * Enable/Disable View
     *
     */
    public void setEnable(boolean flag) {
        for(int index = 0 ; index <tempButton.length ; index++)
        {
            for(int count = 0; count < tempButton.length ; count++)
                tempButton[index][count].setEnabled(flag);
        }
    }

    public void setValue(TTTView play, TTTView.State val, String playerName) {
        if (play.getState() == TTTView.State.EMPTY) {
            play.setState(val);
            play.setEnabled(false);

            if (isWinner(val)) {
                result.setText(playerName + " WINS THE GAME");
                setEnable(false);

            } else if(isDraw()){
                result.setText("DRAW");
                setEnable(false);
            }
        }
    }

    /**
     *
     * Decides turn of a player
     */
    public void getTurn(View v) {
        TTTView play = (TTTView) findViewById(v.getId());
        if (turn == 0) {
            setValue(play, TTTView.State.CROSS, firstPlayer);
            turn++;


        } else if (turn == 1) {
            setValue(play, TTTView.State.CIRCLE, secondPlayer);
            turn--;
        }


    }

    /**
     *
     * Reset New Game
     */
    public void newGame(View v) {

        for(int index = 0 ; index < tempButton.length ; index++)
        {
            for(int count = 0 ; count < tempButton.length ; count++)
                tempButton[index][count].setState(TTTView.State.EMPTY);
        }
        setEnable(true);
        result.setText("");
        turn = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        firstPlayer = getIntent().getStringExtra("first");
        secondPlayer = getIntent().getStringExtra("second");
        mCircleResId = R.drawable.eraser;
        mCrossResId = R.drawable.sharpner;
        createButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
