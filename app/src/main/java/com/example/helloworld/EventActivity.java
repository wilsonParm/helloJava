package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.util.ToastUtil;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = this.<Button>findViewById(R.id.btn_event);

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
}
