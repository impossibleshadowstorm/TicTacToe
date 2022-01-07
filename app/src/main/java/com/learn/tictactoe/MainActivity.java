package com.learn.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ImageView cell0, cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8;
    TextView player_status;

    Boolean gameActive  = true;

    // 0 - x
    // 1 - 0
    // 2 - null

    int activePLayer = 0;
    int[] gameState= {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                            {0, 4, 8}, {2, 4, 6}};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding Views
        cell0 = (ImageView) findViewById(R.id.cell0);
        cell1 = (ImageView) findViewById(R.id.cell1);
        cell2 = (ImageView) findViewById(R.id.cell2);
        cell3 = (ImageView) findViewById(R.id.cell3);
        cell4 = (ImageView) findViewById(R.id.cell4);
        cell5 = (ImageView) findViewById(R.id.cell5);
        cell6 = (ImageView) findViewById(R.id.cell6);
        cell7 = (ImageView) findViewById(R.id.cell7);
        cell8 = (ImageView) findViewById(R.id.cell8);

        player_status = (TextView) findViewById(R.id.player_status);
        player_status.setText("Player X's Turn - Tap to Play");


        // Binding Clicks
        cell0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerTap(v);
            }
        });

        cell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerTap(v);
            }
        });

        cell2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerTap(v);
            }
        });

        cell3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerTap(v);
            }
        });

        cell4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerTap(v);
            }
        });

        cell5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerTap(v);
            }
        });

        cell6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerTap(v);
            }
        });

        cell7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerTap(v);
            }
        });

        cell8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerTap(v);
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void playerTap(View v) {
        ImageView img = (ImageView) v;

        player_status = findViewById(R.id.player_status);

        int tappedImage = Integer.parseInt(img.getTag().toString());

        if (!gameActive){
            resetGame(v);
        }
        int count = 0;

        for (int i = 0; i < gameState.length; i++) {
            if (gameState[i] == 2){
                count += 1;
            }
        }

        if (count == 0){
            resetGame(v);
        }

        if (gameState[tappedImage] == 2){
            gameState[tappedImage] = activePLayer;
            img.setTranslationY(-1000f);

            if (activePLayer == 0){
                img.setImageResource(R.drawable.x);
                activePLayer = 1;
                player_status.setText("Player 0's Turn - Tap to Play");
            }
            else {
                img.setImageResource(R.drawable.o);
                activePLayer = 0;
                player_status.setText("Player X's Turn - Tap to Play");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }

        for (int[] winPosition: winPositions){
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2){

                gameActive = false;

                if (gameState[winPosition[0]] == 0){
                    player_status.setText("Player X has won!!");
                }
                else{
                    player_status.setText("Player O has won!!");
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void resetGame(View v) {
        gameActive = true;
        activePLayer = 0;

        Arrays.fill(gameState, 2);

        ((ImageView) findViewById(R.id.cell0)).setImageResource(0);
        ((ImageView) findViewById(R.id.cell1)).setImageResource(0);
        ((ImageView) findViewById(R.id.cell2)).setImageResource(0);
        ((ImageView) findViewById(R.id.cell3)).setImageResource(0);
        ((ImageView) findViewById(R.id.cell4)).setImageResource(0);
        ((ImageView) findViewById(R.id.cell5)).setImageResource(0);
        ((ImageView) findViewById(R.id.cell6)).setImageResource(0);
        ((ImageView) findViewById(R.id.cell7)).setImageResource(0);
        ((ImageView) findViewById(R.id.cell8)).setImageResource(0);

        player_status = (TextView) findViewById(R.id.player_status);
        player_status.setText("PLayer X's Turn - Tap to Play");
    }
}