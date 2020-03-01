package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.util.ToastUtil;
import com.example.helloworld.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEvent;
    private MyButton btnMy;//new了一个MyButton这个class的方法，下面再进行绑定

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = this.<Button>findViewById(R.id.btn_event);
        btnMy = findViewById(R.id.btn_my);
        btnMy.setOnTouchListener(new View.OnTouchListener() {//先listener再回调
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.v("Listener", "---OnTouch---");
                        break;
                }
                return false;
            }
        });

        //所有监听都打开的话，实际是覆盖操作，最后一个有效
        //layout的onClick是跟着布局最先设置的所以第一个被覆盖

        //①内部类实现
//        mBtnEvent.setOnClickListener(new O  nClick());
        //②匿名内部类
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showMsg(EventActivity.this,"click...");
//            }
//        });
        //③通过事件源所在的类实现
//        mBtnEvent.setOnClickListener(EventActivity.this);
        //④通过外部类实现 （不怎么常见，也能用）
//        mBtnEvent.setOnClickListener(new MyclickListener(EventActivity.this ));
        //⑤写在layout里的onClick，调用自定义的show
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this,"click...");
                break;

        }
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_event:
                    ToastUtil.showMsg(EventActivity.this,"click...");
                    break;
            }
        }
    }

    public void show(View v){
        switch(v.getId()){
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this,"click...");
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.v("EventActivity", "onTouchEvent");
                break;
        }
        return false;
    }
}
