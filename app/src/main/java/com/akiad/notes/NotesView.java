package com.akiad.notes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class NotesView extends Activity {
    EditText NotesEditText;
    Button SaveBut;
    TextView temp;
    Integer position;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notesview);
        NotesEditText = findViewById(R.id.NotesEditText);
        final Bundle extras = getIntent().getExtras();
        String text1 = extras.getString("101") ;
        temp = findViewById(R.id.temp);
        position = extras.getInt("104");
        temp.setText(position.toString());
        NotesEditText.setText(text1);
        SaveBut = findViewById(R.id.SaveBut);
        SaveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                prefs.edit().putBoolean("isSelected",true).apply();
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                intent.putExtra("103",NotesEditText.getText().toString());
                intent.putExtra("105",position);
                Toast.makeText(v.getContext(),"Saved",Toast.LENGTH_SHORT).show();
                v.getContext().startActivity(intent);
                finish();

            }
        });



    }


}
