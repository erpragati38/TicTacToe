package com.pragatiplusplus.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class DashBoard extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }


    public void startPlay(View v)
    {
        EditText p1 = (EditText)findViewById(R.id.player1);
        EditText p2 = (EditText)findViewById(R.id.player2);
        String firstPlayer = p1.getText().toString();
        String secondPlayer = p2.getText().toString();
        if(firstPlayer.equals("")||secondPlayer.equals("") )
            p1.setError("Player1 or player 2 is required");
        else {
            Intent intent = new Intent(DashBoard.this, PlayActivity.class);
            intent.putExtra("first", firstPlayer);
            intent.putExtra("second", secondPlayer);
            startActivity(intent);
        }

    }


}
