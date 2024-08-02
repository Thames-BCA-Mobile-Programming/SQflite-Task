package com.Amisha.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.Amisha.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText, ageEditText, occupationEditText, addressEditText;
    private ArrayList<String> dataList;

    ArrayList<UserDataModel> userDataModels = new ArrayList<UserDataModel>();
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        occupationEditText = findViewById(R.id.occupationEditText);
        addressEditText = findViewById(R.id.addressEditText);
        Button addButton = findViewById(R.id.addButton);
        Button recyclerViewButton = findViewById(R.id.recyclerViewButton);

        // Initialize data list
        dataList = new ArrayList<>();
        dbHelper = new DbHelper(MainActivity.this);

        fetchDbData();
        // Set onClick listeners for buttons
        addButton.setOnClickListener(v -> addData());



        recyclerViewButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, com.Amisha.myapplication.RecyclerViewActivity.class);
            intent.putExtra("dataList", userDataModels);
            startActivity(intent);
        });
    }
    private void fetchDbData(){
        Cursor cursor = dbHelper.reaData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data Available!", Toast.LENGTH_SHORT).show();

        }else{
            while (cursor.moveToNext()){
                String nameFromDb = cursor.getString(1);
                String ageFromDb = cursor.getString(2);
                String occupationFromDb = cursor.getString(3);
                String addressFromDb = cursor.getString(4);
                userDataModels.add( new UserDataModel(nameFromDb,Integer.parseInt(ageFromDb),occupationFromDb,addressFromDb));
            }

        }
    }

    private void addData() {
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String occupation = occupationEditText.getText().toString();
        String address = addressEditText.getText().toString();
        long res = dbHelper.addUsers(new UserDataModel(name, Integer.parseInt(age),occupation, address));


        if (res == -1) {
            Toast.makeText(MainActivity.this, "Failed to insert data", Toast.LENGTH_SHORT).show();
        } else {
            nameEditText.setText("");
            ageEditText.setText("");
            occupationEditText.setText("");
            addressEditText.setText("");

        }
    }
}
