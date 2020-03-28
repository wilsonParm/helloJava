package com.example.helloworld.dataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnSharePreference,mBtnFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        mBtnSharePreference = this.<Button>findViewById(R.id.btn_sharePreference);
        mBtnSharePreference.setOnClickListener(this);
        mBtnFile = findViewById(R.id.btn_file);
        mBtnFile.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_sharePreference:
                intent = new Intent(DataStorageActivity.this, SharedPreferenceActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this, FileActivity.class);
                break;
        }
        startActivity(intent);
    }
}
