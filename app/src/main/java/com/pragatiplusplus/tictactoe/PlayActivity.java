package com.pragatiplusplus.tictactoe;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.pragatiplusplus.tictactoe.ui.view.TTTView;


public class PlayActivity extends ActionBarActivity {

    private String mFirstPlayer;
    private String mSecondPlayer;
    private int mTurn = 0;
    private TextView mResult;
    private int mCircleResId;
    private int mCrossResId;
    private TTTView mTttBoard[][];

    /**
     * Create Buttons
     */
    public void createButton() {
        mTttBoard = new TTTView[3][3];
        mTttBoard[0][0] = (TTTView) findViewById(R.id.row1col1);
        mTttBoard[0][1] = (TTTView) findViewById(R.id.row1col2);
        mTttBoard[0][2] = (TTTView) findViewById(R.id.row1col3);
        mTttBoard[1][0] = (TTTView) findViewById(R.id.row2col1);
        mTttBoard[1][1] = (TTTView) findViewById(R.id.row2col2);
        mTttBoard[1][2] = (TTTView) findViewById(R.id.row2col3);
        mTttBoard[2][0] = (TTTView) findViewById(R.id.row3col1);
        mTttBoard[2][1] = (TTTView) findViewById(R.id.row3col2);
        mTttBoard[2][2] = (TTTView) findViewById(R.id.row3col3);
        mResult = (TextView) findViewById(R.id.output);
        setXYDrawable();
        newGame(mResult);


    }

    private void setXYDrawable() {
        for(int i = 0; i < mTttBoard.length; i++) {
            for(int j = 0; j < mTttBoard[0].length; j++) {
                mTttBoard[i][j].setCircleDrawable(mCircleResId);
                mTttBoard[i][j].setCrossDrawable(mCrossResId);
            }
        }

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
                mResult.setText(playerName + " WINS THE GAME");
                setEnable(false);

            } else if (isDraw()) {
                mResult.setText("DRAW");
                setEnable(false);
            }
        }
    }

    /**
     * Decides turn of a player
     */
    public void getTurn(View v) {
        TTTView play = (TTTView) findViewById(v.getId());
        if (mTurn == 0) {
            setValue(play, TTTView.State.CROSS, mFirstPlayer);
            mTurn++;
        } else if (mTurn == 1) {
            setValue(play, TTTView.State.CIRCLE, mSecondPlayer);
            mTurn--;
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
        mResult.setText("");
        mTurn = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        mFirstPlayer = getIntent().getStringExtra("first");
        mSecondPlayer = getIntent().getStringExtra("second");
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
