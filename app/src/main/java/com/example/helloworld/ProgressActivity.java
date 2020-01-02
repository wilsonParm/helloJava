package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.helloworld.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mpb3;
    private Button mBtnStart,mBtnProgressDialog1,mBtnProgressDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mpb3 = findViewById(R.id.pd3);
        mBtnStart = findViewById(R.id.btn_start);
        mBtnProgressDialog1 = findViewById(R.id.btn_progress_dialog1);
        mBtnProgressDialog2 = findViewById(R.id.btn_progress_dialog2);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.sendEmptyMessage(0);
            }
        });
        mBtnProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressBar progressBar = new ProgressBar(ProgressActivity.this);
                progressBar.setVisibility(View.VISIBLE);
//                progressBar.setList  视频上的progressDialog被弃用了，不知道怎么监听取消setOnCancelListener
            }
        });
        mBtnProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressBar progressBar = new ProgressBar(ProgressActivity.this);
//                progressBar.setScrollBarStyle();setScrollBarStyle
            }
        });
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.sendEmptyMessage(0);
            }
        });


    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(mpb3.getProgress()< 100){
//                mpb3.setProgress(mpb3.getProgress()+5);
                handler.postDelayed(runnable, 500);
            }else{
                ToastUtil.showMsg(ProgressActivity.this, "加载完成");
                mpb3.setProgress(0);
                handler.sendEmptyMessage(0);//重复加载
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mpb3.setProgress(mpb3.getProgress()+5);
            handler.sendEmptyMessage(0);
        }
    };
}
