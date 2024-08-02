package com.Amisha.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Amisha.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ArrayList<UserDataModel> receivedList = (ArrayList<UserDataModel>) getIntent().getSerializableExtra("dataList");
        Log.d( "onCreate: ",""+receivedList.size());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       RecyclerViewAdapter adapter = new RecyclerViewAdapter(receivedList);
        recyclerView.setAdapter(adapter);
    }
}


