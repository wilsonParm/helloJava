package com.example.helloworld.Broad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloworld.R;

public class BroadActivity extends AppCompatActivity {

    private Button mBtn1;
    private TextView mTvTest;
    private MyBroadcast mBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);

        //通过广播来实现下一个页面修改这个页面的东西，但实际上只需要

        mBtn1 = this.<Button>findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BroadActivity.this, BroadActivity_2.class);
                startActivity(intent);
            }
        });

        mTvTest = this.<TextView>findViewById(R.id.tv_test);

        mBroadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.update");//在这个广播名才接受
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcast, intentFilter);
    }

    private class MyBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {//接受到广播后干嘛
            switch(intent.getAction()){
                case "com.example.update"://筛选广播名
                    mTvTest.setText("23333");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcast);
    }
}
