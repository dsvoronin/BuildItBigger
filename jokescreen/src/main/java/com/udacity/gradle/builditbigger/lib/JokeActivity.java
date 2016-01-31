package com.udacity.gradle.builditbigger.lib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private static final String KEY_JOKE = "key_joke";

    public static Intent showJokeActivity(Context context, String joke) {
        return new Intent(context, JokeActivity.class).putExtra(KEY_JOKE, joke);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeView = (TextView) findViewById(R.id.joke);

        String joke = getIntent().getStringExtra(KEY_JOKE);
        jokeView.setText(joke);
    }
}
