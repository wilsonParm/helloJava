package com.example.helloworld.dataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;
import com.example.helloworld.util.ToastUtil;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnSharePreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        mBtnSharePreference = this.<Button>findViewById(R.id.btn_sharePreference);
        mBtnSharePreference.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        ToastUtil.showMsg(this, "click");
        Log.v("asd","onclick");
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_sharePreference:
                ToastUtil.showMsg(this, "click");
                intent = new Intent(DataStorageActivity.this, SharePreferenceActivity.class);
                break;
        }
        startActivity(intent);
    }
}
