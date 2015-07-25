package com.pragatiplusplus.tictactoe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PlayActivity extends ActionBarActivity {

    String firstPlayer;
    String secondPlayer;
    int turn = 0;
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private TextView result;

    public void createButton() {
        b1 = (Button) findViewById(R.id.row1col1);
        b2 = (Button) findViewById(R.id.row1col2);
        b3 = (Button) findViewById(R.id.row1col3);
        b4 = (Button) findViewById(R.id.row2col1);
        b5 = (Button) findViewById(R.id.row2col2);
        b6 = (Button) findViewById(R.id.row2col3);
        b7 = (Button) findViewById(R.id.row3col1);
        b8 = (Button) findViewById(R.id.row3col2);
        b9 = (Button) findViewById(R.id.row3col3);
        result = (TextView) findViewById(R.id.output);
    }

    public boolean isDraw() {
        boolean flag = false;

        if (!TextUtils.isEmpty(b1.getText()) && !TextUtils.isEmpty(b2.getText()) && !TextUtils.isEmpty(b3.getText())
                && !TextUtils.isEmpty(b4.getText()) && !TextUtils.isEmpty(b5.getText()) && !TextUtils.isEmpty(b6.getText())
                && !TextUtils.isEmpty(b7.getText()) && !TextUtils.isEmpty(b8.getText()) && !TextUtils.isEmpty(b9.getText()))
            flag = true;
        return flag;
    }

    public boolean isWinner(String chance) {
        boolean flag = false;
        if (b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText()) && b3.getText().equals(chance))
            flag = true;
        else if (b4.getText().equals(b5.getText()) && b5.getText().equals(b6.getText()) && b6.getText().equals(chance))
            flag = true;
        else if (b7.getText().equals(b8.getText()) && b8.getText().equals(b9.getText()) && b9.getText().equals(chance))
            flag = true;
        else if (b1.getText().equals(b4.getText()) && b4.getText().equals(b7.getText()) && b7.getText().equals(chance))
            flag = true;
        else if (b2.getText().equals(b5.getText()) && b5.getText().equals(b8.getText()) && b8.getText().equals(chance))
            flag = true;
        else if (b3.getText().equals(b6.getText()) && b6.getText().equals(b9.getText()) && b9.getText().equals(chance))
            flag = true;

        else if (b3.getText().equals(b5.getText()) && b5.getText().equals(b7.getText()) && b7.getText().equals(chance))
            flag = true;

        else if (b1.getText().equals(b5.getText()) && b5.getText().equals(b9.getText()) && b9.getText().equals(chance))
            flag = true;

        return flag;


    }

    public void setState(boolean flag) {
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

    public void setValue(Button play, String val, String playerName) {
        if (play.getText().equals("")) {
            play.setText(val);
            play.setEnabled(false);
            boolean check = isWinner(val);

            if (check) {
                result.setText(playerName + " WINS THE GAME");
                setState(false);

            } else {
                boolean check2 = isDraw();
                if (check2)
                    result.setText("DRAW");
            }
        }
    }

    public void getTurn(View v) {
        Button play = (Button) findViewById(v.getId());
        if (turn == 0) {
            setValue(play, "X", firstPlayer);
            turn++;


        } else if (turn == 1) {
            setValue(play, "O", secondPlayer);
            turn--;
        }


    }

    public void newGame(View v) {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        setState(true);
        result.setText("");
        turn = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        firstPlayer = getIntent().getStringExtra("first");
        secondPlayer = getIntent().getStringExtra("second");
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
