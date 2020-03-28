package com.example.helloworld.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.helloworld.R;

public class ObjectAnimActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);

        tvTest = this.<TextView>findViewById(R.id.tv);
//        tvTest.animate().translationYBy(500).setDuration(2000).start();
//        tvTest.animate().translationY(500).setDuration(2000).start();

//        tvTest.animate().alpha(0).setDuration(2000).start();//透明度变为0

//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                //0~1
//                Log.d("aaaa",valueAnimator.getAnimatedValue()+"");
//                //0.0~1.0
//                Log.d("aaaa",valueAnimator.getAnimatedFraction()+"");
//            }
//        });
//        valueAnimator.start();

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvTest,"translationY", 0, 500, 200);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }
}
