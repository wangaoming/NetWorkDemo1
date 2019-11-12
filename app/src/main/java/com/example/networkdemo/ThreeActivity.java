package com.example.networkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThreeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button t_weather;
    private  Button t_oil;
    private  Button t_news;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        t_weather = findViewById(R.id.weather);
        t_oil = findViewById(R.id.oil);
        t_news = findViewById(R.id.news);
        t_weather.setOnClickListener(this);
        t_oil.setOnClickListener(this);
        t_news.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.weather:
            break;
        case R.id.oil:
                break;
        case R.id.news:
                break;

    }
    }
}
