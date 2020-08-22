package com.shivamproject.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    boolean gameActive = true;
    // 0=0
    //  1=x
    //2 = null


    int activeplayer = 0;
    int [] gamestate = {2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2  };
    int [][] winposition = {{0,1,2},{3,4,5},{6,7,8},
                           {0,3,6},{1,4,7},{2,5,8},
                             {0,4,8},{2,4,6}};

    public void playertap(View view)
    {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString() );
        if(!gameActive)
        {
            gameReset(view);
        }
        if(gamestate[tappedImage] == 2 && gameActive)
        {
            gamestate[tappedImage] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.axe);
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("o's turn tap to play");

            }
            else
                {
                img.setImageResource(R.drawable.bxe);
                activeplayer = 0;
                    TextView status = findViewById(R.id.status);
                    status.setText("x's turn tap to play");

            }




            img.animate().translationYBy(1000f).setDuration(300);
        }

        for(int[] winposition: winposition)
        {
            if(gamestate[winposition [0]] == gamestate [winposition[1]] &&
                    gamestate[winposition [1]] == gamestate [winposition[2]] &&
                    gamestate[winposition [0]] != 2)
            {
                String winnerStr;
                gameActive = false;
                if (gamestate[winposition [0]] == 0)
                {
                    winnerStr =  "X has won, next time O";
                }
                else
                {
                    winnerStr =  "O has won,next time X";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);

       }


    }

    }
    public void gameReset(View view) {
        gameActive = true;
        activeplayer = 0;
        for (int i = 0; i < gamestate.length; i++)
        {

            gamestate[i] = 2;
        }

            ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

             TextView status = findViewById(R.id.status);
             status.setText("x's turn tap to play");

         }
    @Override
    protected void onCreate(Bundle savedInstanceState)
            {
              super.onCreate(savedInstanceState);
              setContentView(R.layout.activity_main);
            }
}