package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Dataset;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.dataStorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI,mBtnEvent,mBtndata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = this.findViewById(R.id.btn_ui);
        mBtnEvent = this.findViewById(R.id.btn_event);

        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);

        mBtndata = this.<Button>findViewById(R.id.btn_data);
        mBtndata.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this,EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
