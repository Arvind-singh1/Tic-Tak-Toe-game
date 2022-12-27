package com.example.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // heart=0,cross=1
    int active=0;
    boolean gameActive=true;
    int[]state={2,2,2,2,2,2,2,2,2};
    int[][]winning={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropIn(View view){
        ImageView image=(ImageView) view;

        int tapped=Integer.parseInt(image.getTag().toString());
        if (state[tapped]==2 && gameActive) {
            state[tapped]=active;
            image.setTranslationY(-50f);
            if (active == 0) {
                image.setImageResource(R.drawable.x);
                active = 1;
            } else {
                image.setImageResource(R.drawable.o);
                active = 0;
            }
            image.animate().translationYBy(100f).rotationBy(3600).setDuration(3000);
            for (int[]winningPosition:winning){
                if(state[winningPosition[0]]==state[winningPosition[1]]&&
                 state[winningPosition[1]]==state[winningPosition[2]]&&
                 state[winningPosition[0]]!=2) {
                     gameActive=false;
                     String winner = "Heart";
                     if (state[winningPosition[0]] == 0) {
                         winner = "Cross";
                     }
                     TextView winnerMessage = (TextView) findViewById(R.id.winnermessage);
                     winnerMessage.setText(winner + " has won!");
                     LinearLayout Layout = (LinearLayout) findViewById(R.id.playagainlayout);
                     Layout.setVisibility(View.VISIBLE);

                 }else {
                     boolean gameIsOver=true;
                     for(int counterState:state) {
                         if (counterState == 2) {
                             gameIsOver = false;
                         }
                     }if(gameIsOver){
                         TextView winnerMessage = (TextView) findViewById(R.id.winnermessage);
                         winnerMessage.setText("it's draw!");
                         LinearLayout Layout = (LinearLayout) findViewById(R.id.playagainlayout);
                         Layout.setVisibility(View.VISIBLE);
                        }
                    }

            }
        }
    }
    public void playAgain(View view){
        LinearLayout Layout=(LinearLayout)findViewById(R.id.playagainlayout);
        Layout.setVisibility(View.INVISIBLE);
        gameActive=true;
        active=0;
        for(int i=0;i<state.length;i++){
            state[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        //GridLayout gridLayout=(GridLayout) findViewById(R.id.gridLayout);
        //for (int i=0;i<gridLayout.getChildCount();i++)
        //{
        //    ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
       // }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}