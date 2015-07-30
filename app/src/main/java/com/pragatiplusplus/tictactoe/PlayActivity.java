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
    private TextView result;
    private int mCircleResId;
    private int mCrossResId;
    TTTView mTttBoard[][];

    /**
     * Create Buttons
     */
    public void createButton() {
        mTttBoard = new TTTView[3][3];
        mTttBoard[0][0] = (TTTView) findViewById(R.id.row1col1);
        setXYDrawable(mTttBoard[0][0]);
        mTttBoard[0][1] = (TTTView) findViewById(R.id.row1col2);
        setXYDrawable(mTttBoard[0][1]);
        mTttBoard[0][2] = (TTTView) findViewById(R.id.row1col3);
        setXYDrawable(mTttBoard[0][2]);
        mTttBoard[1][0] = (TTTView) findViewById(R.id.row2col1);
        setXYDrawable(mTttBoard[1][0]);
        mTttBoard[1][1] = (TTTView) findViewById(R.id.row2col2);
        setXYDrawable(mTttBoard[1][1]);
        mTttBoard[1][2] = (TTTView) findViewById(R.id.row2col3);
        setXYDrawable(mTttBoard[1][2]);
        mTttBoard[2][0] = (TTTView) findViewById(R.id.row3col1);
        setXYDrawable(mTttBoard[2][0]);
        mTttBoard[2][1] = (TTTView) findViewById(R.id.row3col2);
        setXYDrawable(mTttBoard[2][1]);
        mTttBoard[2][2] = (TTTView) findViewById(R.id.row3col3);
        setXYDrawable(mTttBoard[2][2]);

        result = (TextView) findViewById(R.id.output);
        newGame(result);
        mTttBoard = new TTTView[3][3];

    }

    private void setXYDrawable(TTTView view) {
        view.setCircleDrawable(mCircleResId);
        view.setCrossDrawable(mCrossResId);
    }

    /**
     * Checks Draw State
     */
    public boolean isDraw() {

        for (int index = 0; index < mTttBoard.length; index++) {
            for (int count = 0; count < mTttBoard.length; count++) {
                if (mTttBoard[index][count].getState() == TTTView.State.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check Winner of the Game
     */
    public boolean isWinner(TTTView.State chance) {
        for (int index = 0; index < mTttBoard.length; index++) {
            if ((mTttBoard[index][0].getState() == chance) && (mTttBoard[index][1].getState() == chance) && (mTttBoard[index][2].getState() == chance)) {
                return true;
            }
        }

        for (int count = 0; count < mTttBoard.length; count++) {
            if ((mTttBoard[0][count].getState() == chance) && (mTttBoard[1][count].getState() == chance) && (mTttBoard[2][count].getState() == chance)) {
                return true;
            }

        }

        if (mTttBoard[0][2].getState() == chance && mTttBoard[1][1].getState() == chance && mTttBoard[2][0].getState() == chance) {
            return  true;
        } else if (mTttBoard[0][0].getState() == chance && mTttBoard[1][1].getState() == chance && mTttBoard[2][2].getState() == chance) {
            return true;

        }
        return false;


    }

    /**
     * Enable/Disable View
     */
    public void setEnable(boolean flag) {
        for (int index = 0; index < mTttBoard.length; index++) {
            for (int count = 0; count < mTttBoard.length; count++)
                mTttBoard[index][count].setEnabled(flag);
        }
    }

    public void setValue(TTTView play, TTTView.State val, String playerName) {
        if (play.getState() == TTTView.State.EMPTY) {
            play.setState(val);
            play.setEnabled(false);

            if (isWinner(val)) {
                result.setText(playerName + " WINS THE GAME");
                setEnable(false);

            } else if (isDraw()) {
                result.setText("DRAW");
                setEnable(false);
            }
        }
    }

    /**
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
     * Reset New Game
     */
    public void newGame(View v) {

        for (int index = 0; index < mTttBoard.length; index++) {
            for (int count = 0; count < mTttBoard.length; count++)
                mTttBoard[index][count].setState(TTTView.State.EMPTY);
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
