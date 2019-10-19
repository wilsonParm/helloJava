package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.helloworld.R.id.BtnToImage;

public class MainActivity extends AppCompatActivity {
    private Button mBtnTextView;
    private Button BtnClass;
    private Button BtnLogView;
    private Button BtnRadio;
    private Button BtnImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextView = this.<Button>findViewById(R.id.BtnToTextview);
        BtnClass = this.<Button>findViewById(R.id.BtnToClass);
        BtnLogView = this.<Button>findViewById(R.id.BtnToLogView);
        BtnRadio = this.<Button>findViewById(R.id.BtnToRadio);
        BtnImage = this.findViewById(BtnToImage);
        setListeners();
    }

    private void setListeners(){
        Onclick onclick = new Onclick();
        mBtnTextView.setOnClickListener(onclick);
        BtnClass.setOnClickListener(onclick);
        BtnLogView.setOnClickListener(onclick);
        BtnRadio.setOnClickListener(onclick);
        BtnImage.setOnClickListener(onclick);
    }

    private class Onclick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch (v.getId()){
                case R.id.BtnToTextview:
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.BtnToClass:
                    intent = new Intent(MainActivity.this, BtnClassPage.class);
                    break;
                case R.id.BtnToLogView:
                    intent = new Intent(MainActivity.this, BasicLog.class);
                    break;
                case R.id.BtnToRadio:
                    intent = new Intent(MainActivity.this, RadioActivity.class);
                    break;
                case BtnToImage:
                    intent = new Intent(MainActivity.this, ImageActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }
}
