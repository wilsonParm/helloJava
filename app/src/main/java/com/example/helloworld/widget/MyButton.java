package com.example.helloworld.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

import com.example.helloworld.util.ToastUtil;

import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN://手指刚刚按下
                Log.v("MyButton", "onTouchEvent");
                break;
        }
        return false;//false：点击事件被listener到了之后回true这次的click就结束了，往后就不回调Ontouch了，若是false的话后面还能回调到OnTouch
    }
}
