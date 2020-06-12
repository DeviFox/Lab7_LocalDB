package com.example.localdb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";

    private Button btnSave, btnDel;
    private EditText editable_itm;

    DatabaseHelper mDatabaseHelper;

    private String selectedItem;
    private int selectedID;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_lt);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnDel = (Button) findViewById(R.id.btn_del);
        editable_itm = (EditText) findViewById(R.id.editable_itm);
        mDatabaseHelper = new DatabaseHelper(this);


        //get the Intent extra from ListDataActivity
        Intent receivedIntent = getIntent();

        //get the itemID and name extra
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedItem = receivedIntent.getStringExtra("name");


        editable_itm.setText(selectedItem);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editable_itm.getText().toString();
                if (!item.equals("")) {
                    mDatabaseHelper.updateName(item, selectedID, selectedItem);
                    toastMessage("Saved!");
                    Intent intent = new Intent(EditActivity.this, ListDataActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    toastMessage("Enter a text!");
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseHelper.delName(selectedID, selectedItem);
                editable_itm.setText("");
                toastMessage("Deleted!");
                Intent intent = new Intent(EditActivity.this, ListDataActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

        private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        }

    }
