package com.example.networkdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button http_url;
private Button ok_http;
private  Button three;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        http_url = findViewById(R.id.httpurl);
        ok_http = findViewById(R.id.okhttp);
        http_url.setOnClickListener(this);
        ok_http.setOnClickListener(this);
        three = findViewById(R.id.three);
        three.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.httpurl:
                Intent intent = new Intent(MainActivity.this, HttpActivity.class);
                startActivity(intent);
                break;
            case R.id.okhttp:
                intent = new Intent(MainActivity.this, OkHttpActivity.class);
                startActivity(intent);
                break;
            case R.id.three:
                intent = new Intent(MainActivity.this, ThreeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
