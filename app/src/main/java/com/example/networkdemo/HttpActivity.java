package com.example.networkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.networkdemo.model.NetworkUtils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class HttpActivity extends AppCompatActivity implements View.OnClickListener {
//    private static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php?ip=221.226.155.7";
    public static final String IP_BASE_URL = "http://ip.taobao.com/service/getIpInfo.php";
    public static final String IP_URL = IP_BASE_URL + "?ip=221.226.155.7";
    private static final String UPLOAD_FILE_URL = "https://api.github.com/markdown/raw";

    private Button t_get;
private Button t_post;
private Button t_up;
private Button t_down;
private TextView net;
private ImageView imageView;
private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_urlconnection);
        t_down = findViewById(R.id.down);
        t_get = findViewById(R.id.get);
        t_post = findViewById(R.id.post);
        t_up = findViewById(R.id.up);
        t_up.setOnClickListener(this);
        t_down.setOnClickListener(this);
        t_get.setOnClickListener(this);
        t_post.setOnClickListener(this);

        net = findViewById(R.id.net);
        net.setOnClickListener(this);
        imageView = findViewById(R.id.tupian);
        imageView.setOnClickListener(this);
        scrollView = findViewById(R.id.scroll);
        scrollView.setOnClickListener(this);


        Glide.with(this).load("https://static.firefoxchina.cn/201910/N20EMvsfSY7uVErFgAk1zs3VPql7lDVNcRA4Cvmx.png").into(imageView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.get:
                scrollView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.GONE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final String result = NetworkUtils.get(IP_URL);

                        if(result != null){
                            Log.d("MainActivity",result);
                            net.post(new Runnable() {
                                @Override
                                public void run() {
                                    net.setText(result);

                                }
                            });
                        }else{
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    net.setText("数据为null");
                                }
                            });
                        }
                    }
                }).start();
                break;
            case R.id.post:
                scrollView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.GONE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                            List<NameValuePair> params = new ArrayList<>();
                            params.add(new BasicNameValuePair("ip", "221.226.155.10"));
                            final String result = NetworkUtils.post(IP_BASE_URL, params);


                            if (result != null) {
                                Log.d("MainActivity", result);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        net.setText(result);

                                    }
                                });
                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        net.setText("请求失败，未获得数据");
                                    }
                                });
                            }
                        }

                }).start();
                break;
            case R.id.up:

                break;
            case R.id.down:
                break;

        }
    }


}
