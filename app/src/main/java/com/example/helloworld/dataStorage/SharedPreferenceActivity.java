package com.example.helloworld.dataStorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class SharedPreferenceActivity extends AppCompatActivity {

    private EditText mEtName;
    private Button mbtnSave,mBtnShow;
    private TextView mTvContent;
    private SharedPreferences mSharedPreference;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        mEtName = this.<EditText>findViewById(R.id.et_name);
        mbtnSave = this.<Button>findViewById(R.id.btn_save);
        mBtnShow = this.<Button>findViewById(R.id.btn_show);
        mTvContent = this.<TextView>findViewById(R.id.tv_content);

        mSharedPreference = getSharedPreferences("data", MODE_PRIVATE);//PRIVATE表示其他应用不能读，还能选择其他应用是否可以读写
        mEditor = mSharedPreference.edit();

        mbtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 mEditor.putString("name", mEtName.getText().toString());//将String数据放进去
                 mEditor.apply();//commit后才生效
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvContent.setText(mSharedPreference.getString("name", ""));
            }
        });
    }
}
