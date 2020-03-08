package com.example.helloworld.dataStorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloworld.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    private EditText mEtName;
    private Button mbtnSave,mBtnShow;
    private TextView mTvContent;
    private SharedPreferences mSharedPreference;
    private SharedPreferences.Editor mEditor;
    private final String mFileName = "test.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        mEtName = this.<EditText>findViewById(R.id.et_name);
        mbtnSave = this.<Button>findViewById(R.id.btn_save);
        mBtnShow = this.<Button>findViewById(R.id.btn_show);
        mTvContent = this.<TextView>findViewById(R.id.tv_content);

        mSharedPreference = getSharedPreferences("data", MODE_PRIVATE);//PRIVATE表示其他应用不能读，还能选择其他应用是否可以读写
        mEditor = mSharedPreference.edit();

        mbtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(mEtName.getText().toString());
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvContent.setText(read());
            }
        });

        //↓2：申请允许写入SD卡，使用的时候还有manifest里面有个permission.WRITE_EXTERNAL_STORAGE也要加上
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    //存储数据  存储到mFileName中
    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try {
//            fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE);//1：内部存储

            {//2：sd卡存储
                File dir = new File(Environment.getExternalStorageDirectory(),"skypan");
                if(!dir.exists()){
                    dir.mkdir();//新建文件夹
                }
                File file = new File(dir,mFileName);
                if(!file.exists()){
                    file.createNewFile();//新建文件
                }
                fileOutputStream = new FileOutputStream(file);
            }
            fileOutputStream.write(content.getBytes());
//            fileOutputStream.close();//1：一定要再关闭掉
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        catch (FileNotFoundException e) {由于FileNotFoundException是IOException的子类，没必要catch了父类后再catch子类了
//            e.printStackTrace();
//        }
    }

    private String read(){
        FileInputStream fileInputStream = null;
        try {
//            fileInputStream = openFileInput(mFileName);//1：内部读取

            {//2：sd外部读取
                File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+ File.separator+"skypan", mFileName);
                fileInputStream = new FileInputStream(file);
            }
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");//字符串拼接，不直接string相加是因为性能问题，StringBUilder不会重复创建新的字符串对象
            int len = 0;
            while((len = fileInputStream.read(buff))>0){
                sb.append(new String(buff, 0, len));
            }
            return sb.toString()
;        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
