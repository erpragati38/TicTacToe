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

    public void createButton() {

        b1 = (TTTView) findViewById(R.id.row1col1);
        setXYDrawable(b1);
        b2 = (TTTView) findViewById(R.id.row1col2);
        setXYDrawable(b2);
        b3 = (TTTView) findViewById(R.id.row1col3);
        setXYDrawable(b3);
        b4 = (TTTView) findViewById(R.id.row2col1);
        setXYDrawable(b4);
        b5 = (TTTView) findViewById(R.id.row2col2);
        setXYDrawable(b5);
        b6 = (TTTView) findViewById(R.id.row2col3);
        setXYDrawable(b6);
        b7 = (TTTView) findViewById(R.id.row3col1);
        setXYDrawable(b7);
        b8 = (TTTView) findViewById(R.id.row3col2);
        setXYDrawable(b8);
        b9 = (TTTView) findViewById(R.id.row3col3);
        setXYDrawable(b9);
        result = (TextView) findViewById(R.id.output);
        newGame(result);
    }

    private void setXYDrawable(TTTView view) {
        view.setCircleDrawable(mCircleResId);
        view.setCrossDrawable(mCrossResId);
    }

    public boolean isDraw() {
        boolean flag = false;

        if (b1.getState() != TTTView.State.EMPTY && b2.getState() != TTTView.State.EMPTY && b3.getState() != TTTView.State.EMPTY
                && b4.getState() != TTTView.State.EMPTY && b5.getState() != TTTView.State.EMPTY && b6.getState() != TTTView.State.EMPTY
                && b7.getState() != TTTView.State.EMPTY && b8.getState() != TTTView.State.EMPTY && b9.getState() != TTTView.State.EMPTY)
            flag = true;
        return flag;
    }

    public boolean isWinner(TTTView.State chance) {
        boolean flag = false;
        if (b1.getState() == chance && b2.getState() == chance && b3.getState() == chance)
            flag = true;
        else if (b4.getState() == chance && b5.getState() == chance && b6.getState() == chance)
            flag = true;
        else if (b7.getState() == chance && b8.getState() == chance && b9.getState() == chance)
            flag = true;
        else if (b1.getState() == chance && b4.getState() == chance && b7.getState() == chance)
            flag = true;
        else if (b2.getState() == chance && b5.getState() == chance && b8.getState() == chance)
            flag = true;
        else if (b3.getState() == chance && b6.getState() == chance && b9.getState() == chance)
            flag = true;

        else if (b3.getState() == chance && b5.getState() == chance && b7.getState() == chance)
            flag = true;

        else if (b1.getState() == chance && b5.getState() == chance && b9.getState() == chance)
            flag = true;

        return flag;


    }

    public void setEnable(boolean flag) {
        b1.setEnabled(flag);
        b2.setEnabled(flag);
        b3.setEnabled(flag);
        b4.setEnabled(flag);
        b5.setEnabled(flag);
        b6.setEnabled(flag);
        b7.setEnabled(flag);
        b8.setEnabled(flag);
        b9.setEnabled(flag);
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

    public void newGame(View v) {
        b1.setState(TTTView.State.EMPTY);
        b2.setState(TTTView.State.EMPTY);
        b3.setState(TTTView.State.EMPTY);
        b4.setState(TTTView.State.EMPTY);
        b5.setState(TTTView.State.EMPTY);
        b6.setState(TTTView.State.EMPTY);
        b7.setState(TTTView.State.EMPTY);
        b8.setState(TTTView.State.EMPTY);
        b9.setState(TTTView.State.EMPTY);
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
