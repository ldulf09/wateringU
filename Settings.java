package com.example.startagain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Settings extends AppCompatActivity  {

    Button backButton;
    private Spinner spinner1;
    String[] dropDownItems = {"Need to drink more", "Need to drink less", "Halfway", "Goal reached"};
    AutoCompleteTextView autoComplete;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        backButton = findViewById(R.id.button_Settings2Home);
        backButton.setOnClickListener(view -> finish());

//        autoComplete = findViewById(R.id.autoComplete);
//        adapterItems = new ArrayAdapter<String>(this,R.layout.list_items,dropDownItems);
//        autoComplete.setAdapter(adapterItems);
//        autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String item = parent.getItemAtPosition(position).toString();
//                Toast.makeText(getApplicationContext(), "Item: "+item,Toast.LENGTH_SHORT).show();
//            }
//        });


      //  spinner1 = findViewById(R.id.spinner1);

    }
}
