package com.example.helloworld.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.helloworld.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRvGrid = findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this, 3));//一行3个的意思
        mRvGrid.setAdapter(
            new GridAdapter(
                GridRecyclerViewActivity.this,
                new GridAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(int pos) {
                        Toast.makeText(GridRecyclerViewActivity.this, "click " + pos, Toast.LENGTH_SHORT).show();
                    }
                },
                new GridAdapter.OnItemLongClickListener() {
                    @Override
                    public void onLongClick(int pos) {
                        Toast.makeText(GridRecyclerViewActivity.this, "long click " + pos, Toast.LENGTH_SHORT).show();
                    }
                }
            )
        );
    }
}
