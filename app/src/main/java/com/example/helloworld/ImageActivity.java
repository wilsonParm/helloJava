package com.example.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {

//    private ImageView mIa00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
//        mIa00 = this.<ImageView>findViewById(R.id.image03);
//        Glide.with(this).load("https://i0.hdslb.com/bfs/sycp/creative_img/201909/3907be0058c19d6b0fc2a90f77d927c1.jpg").into(mIa00);
    }
}
