package com.example.gtf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {

    private static final  String TAG = "MainActivity";

    DatabaseHelper mDatabaseHelper;
    private Button btn1,btn2;
    private EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        txt = (EditText) findViewById(R.id.txt);
        btn1 = (Button) findViewById(R.id.btnadd2);
        btn2 = (Button) findViewById(R.id.btnback2);
        mDatabaseHelper = new DatabaseHelper(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = txt.getText().toString();
                if (txt.length() != 0) {
                    AddData(newEntry);
                    txt.setText("");
                }else {
                    toastMessage("You must put something in the text field!");
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity7.this, MainActivity6.class);
                startActivity(intent);
            }
        });

    }
    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);
        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        }else {
            toastMessage("Something Went Wrong");
        }

    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}