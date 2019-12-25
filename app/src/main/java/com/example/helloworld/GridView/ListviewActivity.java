package com.example.helloworld.GridView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.helloworld.R;

public class ListviewActivity extends AppCompatActivity {

    private GridView mGv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mGv = findViewById(R.id.iGridView);
//        mgv.set //
    }
}
