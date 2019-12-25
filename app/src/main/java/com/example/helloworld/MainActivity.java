package com.example.helloworld;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.listView.ListViewActivity;

import static com.example.helloworld.R.id.BtnToImage;
import static com.example.helloworld.R.id.BtnToListview;

public class MainActivity extends AppCompatActivity {
    private Button mBtnTextView;
    private Button BtnClass;
    private Button BtnLogView;
    private Button BtnRadio;
    private Button BtnImage;
    private Button mBtnListview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextView = this.<Button>findViewById(R.id.BtnToTextview);
        BtnClass = this.<Button>findViewById(R.id.BtnToClass);
        BtnLogView = this.<Button>findViewById(R.id.BtnToLogView);
        BtnRadio = this.<Button>findViewById(R.id.BtnToRadio);
        BtnImage = this.<Button>findViewById(BtnToImage);
        mBtnListview = this.<Button>findViewById(BtnToListview);
        setListeners();
    }

    private void setListeners(){
        Onclick onclick = new Onclick();
        mBtnTextView.setOnClickListener(onclick);//设置了点击事件点击后跳转到onclick
        BtnClass.setOnClickListener(onclick);
        BtnLogView.setOnClickListener(onclick);
        BtnRadio.setOnClickListener(onclick);
        BtnImage.setOnClickListener(onclick);
        mBtnListview.setOnClickListener(onclick);

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
                    intent = new Intent(MainActivity.this, BasicLog.class);
//                    intent = new Intent(MainActivity.this, BtnClassPage.class);
                    break;
                case R.id.BtnToLogView:
                    intent = new Intent(MainActivity.this, BasicLog.class);
                    break;
                case R.id.BtnToRadio:
                    intent = new Intent(MainActivity.this, RadioActivity.class);
                    break;
                case R.id.BtnToImage:
                    intent = new Intent(MainActivity.this, ImageActivity.class);
                    break;
                case R.id.BtnToListview:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }
}
