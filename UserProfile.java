package com.example.startagain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {
    public static final String USER_NAME = "com.example.application.example.USER_NAME";
    public static final String USER_WEIGHT = "com.example.application.example.USER_WEIGHT";
    Button updateButton;
    public static final String TAG = "YOUR-TAG-NAME";
    TextInputLayout regName, regSex, regHeight, regWeight;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        regName = findViewById(R.id.nameInput);
        regSex = findViewById(R.id.sexInput);
        regHeight = findViewById(R.id.heightInput);
        regWeight = findViewById(R.id.weightInput);

        updateButton = findViewById(R.id.updateButton);
        updateButton.setOnClickListener(view -> finish());

        // Writing to database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        DatabaseReference nameRef = database.getReference("name");

        TextView userNombre = (TextView) findViewById(R.id.nameInput);
        String nameOutput = "test"; //userNombre.getText().toString();

        myRef.setValue("Hello, World!");
        nameRef.setValue(nameOutput);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("User");

                reference.setValue("First data storage");
            }
        });

        // Read from the database
//        nameRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });

    }

    // stores variables and opens main
    public void openMain() {
        EditText editText1 = (EditText) findViewById(R.id.nameInput);
        String name = editText1.getText().toString();

        EditText editText2 = (EditText) findViewById(R.id.weightInput);
        int weight = Integer.parseInt(editText2.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(USER_NAME, name);
        intent.putExtra(USER_WEIGHT, weight);
        startActivity(intent);
    }


}