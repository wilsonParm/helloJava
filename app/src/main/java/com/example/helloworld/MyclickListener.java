package com.example.helloworld;

import android.app.Activity;
import android.view.View;

import com.example.helloworld.util.ToastUtil;

public class MyclickListener implements View.OnClickListener{

    private Activity mActivity;

    public MyclickListener(Activity activity){
        this.mActivity = activity;
    }

    @Override
    public void onClick(View v) {
        ToastUtil.showMsg(mActivity,"click,,,");
    }
}
