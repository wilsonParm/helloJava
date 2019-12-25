package com.example.helloworld.gridview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class GridViewActivity extends AppCompatActivity {

    private GridView mGv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        mGv = this.findViewById(R.id.gv);
        mGv.setAdapter(new MyGridAdapter(GridViewActivity.this) );
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this,"click pos"+ i,Toast.LENGTH_SHORT).show();
            }
        });
        mGv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this,"long press pos"+i,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
