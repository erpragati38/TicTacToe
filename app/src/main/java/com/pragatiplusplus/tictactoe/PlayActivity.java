package com.pragatiplusplus.tictactoe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class PlayActivity extends ActionBarActivity {

    String firstPlayer;
    String secondPlayer;
    int turn = 0 ;
    public void getTurn(View v)
    {
        Button play= (Button)findViewById(v.getId());
        if(turn == 0)
        {
           if(play.getText().equals(""))
           {
               play.setText("X");
               play.setEnabled(false);
               turn++;
           }
        }

        if(turn == 1)
        {
            if(play.getText().equals(""))
            {
                play.setText("O");
                play.setEnabled(false);
                turn--;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
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
