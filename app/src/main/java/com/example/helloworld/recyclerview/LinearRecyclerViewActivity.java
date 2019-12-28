package com.example.helloworld.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        mRvMain = this.<RecyclerView>findViewById(R.id.rv_main);
        mRvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        mRvMain.addItemDecoration(new MyDecoration());
        mRvMain.setAdapter(new LineraAdapter(
            LinearRecyclerViewActivity.this,
            new LineraAdapter.OnItemClickListener()
            {
                //           回调了一个点击事件过来并且在这做处理
                @Override
                public void onClick(int pos) {
                    Toast.makeText(LinearRecyclerViewActivity.this, "click"+pos, Toast.LENGTH_SHORT).show();
                }
            }, new LineraAdapter.OnItemLongClickListener() {
                @Override
                public void onLongClick(int pos) {
                    Toast.makeText(LinearRecyclerViewActivity.this, "longclick"+pos, Toast.LENGTH_SHORT).show();
                }
            }
        ));
    }

    /**
     * 目前用来设置分割线
     */
    class  MyDecoration extends  RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}
