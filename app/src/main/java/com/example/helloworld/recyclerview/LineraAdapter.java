package com.example.helloworld.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;

public class LineraAdapter extends RecyclerView.Adapter<LineraAdapter.LinearViewHolder> {

    private Context mContext;
    public LineraAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public LineraAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LineraAdapter.LinearViewHolder holder, int position) {
        holder.textView.setText("hello World");
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
}
