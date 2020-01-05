package com.example.helloworld.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;
import com.example.helloworld.util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button mbtnJump,mbtnJump2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mbtnJump = findViewById(R.id.btn_jump);
        mbtnJump.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //显式调用
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "潮哥");
                bundle.putInt("age", 25);
                intent.putExtras(bundle);
//                startActivity(intent);
                startActivityForResult(intent, 0);

//                Intent intent = new Intent();
//                intent.setClass(AActivity.this, BActivity.class);
//                startActivity(intent);

//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this, "com.example.helloworld.jump.BActivity");
//                startActivity(intent);

//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this, "com.example.helloworld.jump.BActivity"));
//                startActivity(intent);

                //隐式跳转
//                Intent intent = new Intent();
//                intent.setAction("com.example.helloworld.text.BActivity");//在Manifest设置了一个隐式跳转
//                startActivity(intent);
            }
        });
        mbtnJump2 = findViewById(R.id.btn_jump2);
        mbtnJump2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(AActivity.this,"jump2");
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ToastUtil.showMsg(AActivity.this, data.getExtras().getString("title"));
    }
}
