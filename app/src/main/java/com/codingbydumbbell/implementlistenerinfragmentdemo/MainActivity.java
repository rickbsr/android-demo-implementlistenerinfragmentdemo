package com.codingbydumbbell.implementlistenerinfragmentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyFragment.MyFragmentInterface {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        getSupportFragmentManager().beginTransaction().add(R.id.container, MyFragment.getInstance()).commit();

    }

    @Override
    public void onSeekBarChanged(int progress) {
        textView.setText(String.valueOf(progress));
    }
}
