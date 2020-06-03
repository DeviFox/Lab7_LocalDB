package com.example.localdb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    DatabaseHelper mDatabaseHelper;
    private Button btn_add, btn_open;
    private EditText  edText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edText = (EditText) findViewById(R.id.edText);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_open = (Button) findViewById(R.id.btn_open);
        mDatabaseHelper = new DatabaseHelper(this);

    }
    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);
    }


        private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
