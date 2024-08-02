package com.Amisha.myapplication;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.Amisha.myapplication.R;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        GridView gridView = findViewById(R.id.gridView);
        ArrayList<String> dataList = getIntent().getStringArrayListExtra("dataList");

        if (dataList == null) {
            dataList = new ArrayList<>();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        gridView.setAdapter(adapter);
    }
}


