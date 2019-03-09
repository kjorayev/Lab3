package com.example.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import android.view.View;
import android.widget.*;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> secretWords = new ArrayList(Arrays.asList("APPLE", "BANANA", "CHERRY"));
    private TextView rndLettersView;
    private TextView correctLettersView;
    private TextView guessView;
    private int place;
    private String word;
    private StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        place = 0;
        rndLettersView = findViewById(R.id.rndLetters);
        correctLettersView = findViewById(R.id.correctLetters);
        guessView = findViewById(R.id.guess);

        String r = getWord();
        rndLettersView.setText(r);


    }

    private String getWord(){
        int num = (int)(Math.random()*secretWords.size()+ 1);
        word = secretWords.get(num);
        String shuffledWord = "";
        ArrayList<String> splitWord = new ArrayList(Arrays.asList(word.split("")));
        Collections.shuffle(splitWord);
        for (String c : splitWord) {
            shuffledWord += c;
        }
        return shuffledWord;
    }

    public void btnClicked(View v){
        String guessedLetter = guessView.getText().toString();
        guessedLetter = guessedLetter.toUpperCase();



        if(guessedLetter.charAt(0) == word.charAt(place)){
            sb.append(guessedLetter);
        }
        correctLettersView.setText(sb.toString());
        guessView.setText("");
        place++;

        if(sb.length() == word.length()){
            correctLettersView.setText("You Win");
        }

    }



}
