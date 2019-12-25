package com.example.helloworld;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

import static com.example.helloworld.R.id.cb_02;
import static com.example.helloworld.R.id.rb_10;

public class RadioActivity extends AppCompatActivity {

    private RadioGroup mRg1;
    private CheckBox mCb00;

    private CheckBox mCb14;
    private CheckBox mCb12;
    private CheckBox mCb13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        mRg1 = findViewById(R.id.rb_10);

        mCb00 = findViewById(R.id.cb_02);



        mRg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                Toast.makeText(RadioActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
            }
        });

        mCb00.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(RadioActivity.this, isChecked?"已选":"未选", Toast.LENGTH_SHORT).show();
            }
        });
        setlisten();

    }
    private void setlisten(){
        mCb12 = findViewById(R.id.cb_12);
        mCb13 = findViewById(R.id.cb_13);
        mCb14 = findViewById(R.id.cb_14);
        mCb12.setOnCheckedChangeListener(listener);//整个layout_10
        mCb13.setOnCheckedChangeListener(listener);//整个layout_10
        mCb14.setOnCheckedChangeListener(listener);//整个layout_10
    }

    private OnCheckedChangeListener listener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.cb_12:
                    Toast.makeText(getApplication(), isChecked?"选择1":"取选1", 0).show();
                    break;
                case R.id.cb_13:
                    Toast.makeText(getApplication(), isChecked?"选择2":"取选2", 0).show();
                    break;
                case R.id.cb_14:
                    Toast.makeText(getApplication(), isChecked?"选择3":"取选3", 0).show();
                    break;
                default:
                    break;
            }

        }
    };
}
