package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BasicLog extends AppCompatActivity {

    private Button mBtnBack;
    private Button mBtnLogin;
    private EditText mLogCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_log);

        mBtnBack = this.<Button>findViewById(R.id.BtnLogBack);
        mBtnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                Intent intent = new Intent(BasicLog.this, MainActivity.class);
                startActivity(intent);
                    }
        });
        mBtnLogin = this.<Button>findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BasicLog.this,"登录中", Toast.LENGTH_SHORT).show();
            }
        });
        mLogCall = this.<EditText>findViewById(R.id.call);
        mLogCall.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("onTextChanged: ",s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}
