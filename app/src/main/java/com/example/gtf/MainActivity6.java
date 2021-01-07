package com.example.gtf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {

    private static final String TAG = "MainActivity6";

    DatabaseHelper mDatabaseHelper;

    private ListView listView;
    private Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        listView = (ListView) findViewById(R.id.view);
        mDatabaseHelper = new DatabaseHelper(this);
        populateListView();

        btn1 = (Button) findViewById(R.id.btnadd);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn2 = (Button) findViewById(R.id.btnback);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String>listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adpter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adpter);
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    public void openActivity5() {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
}