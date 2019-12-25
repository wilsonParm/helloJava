package com.example.helloworld.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.helloworld.R;

import javax.microedition.khronos.opengles.GL;

public class MyGridAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyGridAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = mLayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.iv_grid);
            holder.textView = (TextView) view.findViewById(R.id.tv_title);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText("圣诞老人");
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577284528916&di=04c8ac1c5ff7017d1699e1c898bc5ba5&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0135b95a420119a80121974164af46.png%401280w_1l_2o_100sh.png").into(holder.imageView);
        return view;
    }
}
