package com.pragatiplusplus.tictactoe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class DashBoard extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dash_board, menu);
        return true;
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
