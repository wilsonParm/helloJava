package com.example.helloworld.Broad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

public class BroadActivity_2 extends AppCompatActivity {

    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_2);

        mBtn = this.<Button>findViewById(R.id.btn_click);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.update");//发送广播,广播名com.example.update
                LocalBroadcastManager.getInstance(BroadActivity_2.this).sendBroadcast(intent);
            }
        });
    }
}
