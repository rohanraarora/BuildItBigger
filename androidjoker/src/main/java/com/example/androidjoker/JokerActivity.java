package com.example.androidjoker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokerActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker);

        TextView jokeView = (TextView)findViewById(R.id.jokeTextView);

        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_JOKE)){
            String joke = intent.getStringExtra(EXTRA_JOKE);
            jokeView.setText(joke);
        }
        else {
            jokeView.setText(R.string.alert_joke_missing_intent);
        }
    }
}
