package com.example.helloworld;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
    private Button mBtnToast;
    private Button mBtnToDialog;
    private Button mBtnToProgress;
    private Button mBtnToDialog2;
    private Button mBtnToPopup;
    private Button mBtnToLife;


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
        mBtnToast = this.<Button>findViewById(R.id.BtnToToast);
        mBtnToDialog = this.<Button>findViewById(R.id.btnToDialog);
        mBtnToProgress = this.<Button>findViewById(R.id.btnToProgress);
        mBtnToDialog2 = this.<Button>findViewById(R.id.BtnToDialog2);
        mBtnToPopup = this.<Button>findViewById(R.id.btnToPopup);
        mBtnToLife = this.<Button>findViewById(R.id.btnToLife);
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
        mBtnToast.setOnClickListener(onclick);
        mBtnToDialog.setOnClickListener(onclick);
        mBtnToProgress.setOnClickListener(onclick);
        mBtnToDialog2.setOnClickListener(onclick);
        mBtnToPopup.setOnClickListener(onclick);
        mBtnToLife.setOnClickListener(onclick);
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
                case R.id.btnToPopup:
                    intent = new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;
                case R.id.btnToLife:
                    intent = new Intent(UIActivity.this, LifeCycleActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Checks the orientation of the screen
        int orienonResumet=getRequestedOrientation();
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else{
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}
