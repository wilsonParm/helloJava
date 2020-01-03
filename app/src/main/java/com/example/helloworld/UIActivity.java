package com.example.helloworld;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.gridview.GridViewActivity;
import com.example.helloworld.listView.ListViewActivity;
import com.example.helloworld.recyclerview.RecyclerViewActivity;
import com.example.helloworld.widget.CustomDialogActivity;

public class UIActivity extends AppCompatActivity {
    private Button mBtnTextView;
    private Button BtnClass;
    private Button BtnLogView;
    private Button BtnRadio;
    private Button BtnImage;
    private Button mBtnListview;
    private Button mBtnGridView;
    private Button mRv;
    private Button mRtnToast;
    private Button mRtnToDialog;
    private Button mRtnToProgress;
    private Button mRtnToDialog2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView = this.<Button>findViewById(R.id.BtnToTextview);
        BtnClass = this.<Button>findViewById(R.id.BtnToClass);
        BtnLogView = this.<Button>findViewById(R.id.BtnToLogView);
        BtnRadio = this.<Button>findViewById(R.id.BtnToRadio);
        BtnImage = this.<Button>findViewById(R.id.BtnToImage);
        mBtnListview = this.<Button>findViewById(R.id.BtnToListview);
        mBtnGridView = this.<Button>findViewById(R.id.BtnToGridView);
        mRv = this.<Button>findViewById(R.id.btnToRecyclerView);
        mRtnToast = this.<Button>findViewById(R.id.BtnToToast);
        mRtnToDialog = this.<Button>findViewById(R.id.btnToDialog);
        mRtnToProgress = this.<Button>findViewById(R.id.btnToProgress);
        mRtnToDialog2 = this.<Button>findViewById(R.id.BtnToDialog2);
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
        mBtnGridView.setOnClickListener(onclick);
        mRv.setOnClickListener(onclick);
        mRtnToast.setOnClickListener(onclick);
        mRtnToDialog.setOnClickListener(onclick);
        mRtnToProgress.setOnClickListener(onclick);
        mRtnToDialog2.setOnClickListener(onclick);
    }

    private class Onclick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch (v.getId()){
                case R.id.BtnToTextview:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.BtnToClass:
                    intent = new Intent(UIActivity.this, BasicLog.class);
                    break;
                case R.id.BtnToLogView:
                    intent = new Intent(UIActivity.this, BasicLog.class);
                    break;
                case R.id.BtnToRadio:
                    intent = new Intent(UIActivity.this, RadioActivity.class);
                    break;
                case R.id.BtnToImage:
                    intent = new Intent(UIActivity.this, ImageActivity.class);
                    break;
                case R.id.BtnToListview:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.BtnToGridView:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.btnToRecyclerView:
                    intent = new Intent(UIActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.BtnToToast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btnToDialog:
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.btnToProgress:
                    intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;
                case R.id.BtnToDialog2:
                    intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }
}
