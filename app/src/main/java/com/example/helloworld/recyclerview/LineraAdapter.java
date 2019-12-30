package com.example.helloworld.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;

public class LineraAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private OnItemClickListener mlistener;
    private OnItemLongClickListener mLlistener;


    public LineraAdapter(Context context, OnItemClickListener listener, OnItemLongClickListener Llistener){
        this.mContext = context;
        this.mlistener = listener;
        this.mLlistener = Llistener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 0){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent,false));
        }else{
            return new LinearViewHolder_2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2, parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position) == 0){
            ((LinearViewHolder)holder).textView.setText("hello World");
        }else {
            ((LinearViewHolder_2) holder).textView.setText("o 哇哈哈哈哈哈");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mlistener.onClick(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mLlistener.onLongClick(position);
                return true;//有关长按事件这里需要设置为true，因为false的话放手时还会出发click事件
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public LinearViewHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }
    class LinearViewHolder_2 extends RecyclerView.ViewHolder{

        private TextView textView;
        private ImageView imageView;

        public LinearViewHolder_2(View itemView){
            super(itemView);
            textView = itemView.<TextView>findViewById(R.id.tv_title);
            imageView = itemView.<ImageView>findViewById(R.id.iv_image);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
    public interface OnItemLongClickListener{
        void onLongClick(int pos);
    }
}
