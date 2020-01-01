package com.example.helloworld;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.helloworld.util.ToastUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private Button mbtnDialog1,mbtnDialog2,mbtnDialog3,mbtnDialog4,mbtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mbtnDialog1 = this.findViewById(R.id.btn_dialog1);
        mbtnDialog2 = this.findViewById(R.id.btn_dialog2);
        mbtnDialog3 = this.findViewById(R.id.btn_dialog3);
        mbtnDialog4 = this.findViewById(R.id.btn_dialog4);
        mbtnDialog5 = this.findViewById(R.id.btn_dialog5);
        OnClick onClick = new OnClick();
        mbtnDialog1.setOnClickListener(onClick);
        mbtnDialog2.setOnClickListener(onClick);
        mbtnDialog3.setOnClickListener(onClick);
        mbtnDialog4.setOnClickListener(onClick);
        mbtnDialog5.setOnClickListener(onClick);

    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答").setMessage("想回答啥都行")
                            .setIcon(R.mipmap.xigua)
                            .setPositiveButton("吼啊",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this,"积极按钮");
                                }
                            }).setNeutralButton("木胡啊", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"为啥啊");
                        }
                    }).setNegativeButton("种胡", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this, "都得了");
                        }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array2 = new String[]{"男","女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,array2[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array3 = new String[]{"男","女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("选择性别");
                    builder3.setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() { //0表示默认第0个选项
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,array3[which]);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    //dialog.dismiss();选择后关闭框，setCancelable(false),点击框框外面框框不消失
                    break;
                case R.id.btn_dialog4:
                    final String[] array4 = new String[]{"唱","跳","rap","篮球"};//卧槽在这里纠结了好久，这两个数组记得长度要一样
                    boolean[] isSelected = new boolean[]{false,false,true,false};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择行为").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DialogActivity.this,array4[which]+":"+isChecked);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this, "click 确定");
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this, "click 取消");

                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog,null);
                    EditText etUserName = view.findViewById(R.id.et_username);
                    EditText etPastWord = view.findViewById(R.id.et_pastword);
                    Button btnLogin = view.findViewById(R.id.btn_log);
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.showMsg(DialogActivity.this, "Loading");
                            //woc不知道怎么关闭dialog了这么写的话
                        }
                    });
                    builder5.setTitle("请先登录").setView(view).show();
                    break;
            }
        }
    }

}
