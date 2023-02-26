package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    boolean gameActive=true;
    int activePlayer=1;
    //1-X
    //0-O
    //2-NULL

    int [] gameState= {2,2,2,2,2,2,2,2,2};
    int [][] winPositions= {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}};

    String winner;

    public void playerTap(View view)
    {


        ImageView img= (ImageView) view;
        TextView status_text;
        status_text=findViewById(R.id.status);
        int tappedImage= Integer.parseInt(img.getTag().toString());

        if(!gameActive)
        {
            gameReset(view);
        }


        if(gameState[tappedImage]==2)
        {
            gameState[tappedImage]=activePlayer;

            if(activePlayer==1)
            {
                img.setImageResource(R.drawable.x);
                activePlayer=0;
                status_text.setText("O's Turn");
            }
            else
            {
                img.setImageResource(R.drawable.zero);
                activePlayer=1;
                status_text.setText("X's Turn");

            }
        }

        for(int k=0; k<3; k++)
        {
            if(gameState[winPositions[k][0]]==gameState[winPositions[k][1]] && gameState[winPositions[k][1]]==gameState[winPositions[k][2]] && gameState[winPositions[k][0]]!=2)
            {
                if(gameState[winPositions[k][0]]==1)
                {
                    winner="X";
                }
                else
                {
                    winner="O";
                }

                gameActive=false;
                status_text.setText(winner+" has won");
            }
        }

        /*for(int []winPosition: winPositions)
        {
            if(gameState[winPosition[0]]==gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]] && gameState[winPosition[0]]!=2)
            {
                if(gameState[winPosition[0]]==1)
                {
                    winner="X";
                }
                else
                {
                    winner="O";
                }

                gameActive=false;
                status_text.setText(winner+" has won");
            }
        }*/
    }

    public void gameReset(View view)
    {
        gameActive=true;
        activePlayer=1;

        for(int i=0; i<gameState.length; i++)
        {
            gameState[i]=2;
        }

        ImageView i0= findViewById(R.id.imageView0);
        i0.setImageResource(0);

        ImageView i1= findViewById(R.id.imageView1);
        i1.setImageResource(0);

        ImageView i2= findViewById(R.id.imageView2);
        i2.setImageResource(0);

        ImageView i3= findViewById(R.id.imageView3);
        i3.setImageResource(0);

        ImageView i4= findViewById(R.id.imageView4);
        i4.setImageResource(0);

        ImageView i5= findViewById(R.id.imageView5);
        i5.setImageResource(0);

        ImageView i6= findViewById(R.id.imageView6);
        i6.setImageResource(0);

        ImageView i7= findViewById(R.id.imageView7);
        i7.setImageResource(0);

        ImageView i8= findViewById(R.id.imageView8);
        i8.setImageResource(0);

        TextView Status=findViewById(R.id.status);
        Status.setText("X's Turn");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



}