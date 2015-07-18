package com.pragatiplusplus.tictactoe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PlayActivity extends ActionBarActivity {

    String firstPlayer;
    String secondPlayer;
    int turn = 0 ;
    private Button b1 , b2, b3, b4, b5,b6,b7,b8,b9;
    private EditText result;
    private boolean flag = false;
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
        result = (EditText) findViewById(R.id.output);
    }

    public boolean isWinner(String chance)
    {
       if(b1.getText().equals(b2.getText())&& b2.getText().equals(b3.getText()) && b3.getText().equals(chance))
           flag = true;
        else if(b4.getText().equals(b5.getText())&& b5.getText().equals(b6.getText()) && b6.getText().equals(chance))
           flag = true;
        else if(b7.getText().equals(b8.getText()) && b8.getText().equals(b9.getText()) && b9.getText().equals(chance))
           flag = true;
        else if(b1.getText().equals(b4.getText())&& b4.getText().equals(b7.getText()) && b7.getText().equals(chance))
           flag = true;
        else if(b2.getText().equals(b5.getText()) && b5.getText().equals(b8.getText()) && b8.getText().equals(chance))
           flag = true;
        else if(b3.getText().equals(b6.getText())&& b6.getText().equals(b9.getText()) && b9.getText().equals(chance))
           flag = true;
        else if(b1.getText().equals(b5.getText())&& b5.getText().equals(b8.getText()) && b8.getText().equals(chance))
           flag = true;
        else if(b3.getText().equals(b5.getText()) && b5.getText().equals(b7.getText())&& b7.getText().equals(chance))
           flag = true;

        return flag;


    }
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

           boolean check=  isWinner("X");
            if(check)
                result.setText("WIN");



        }

        if(turn == 1)
        {
            if(play.getText().equals(""))
            {
                play.setText("O");
                play.setEnabled(false);
                turn--;
            }
  boolean check= isWinner("O");
            if(check)
            result.setText("WIN");


        }
    }

    public void newGame(View v)
    {
        b1.setText("");
        b1.setEnabled(true);
        b2.setText("");
        b2.setEnabled(true);
        b3.setText("");
        b3.setEnabled(true);
        b4.setText("");
        b4.setEnabled(true);
        b5.setText("");
        b5.setEnabled(true);
        b6.setText("");
        b6.setEnabled(true);
        b7.setText("");
        b7.setEnabled(true);
        b8.setText("");
        b8.setEnabled(true);
        b9.setText("");
        b9.setEnabled(true);
        result.setText("");
        turn = 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
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
