package com.akiad.notes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class NotesView extends Activity {
    EditText NotesEditText;
    Button SaveBut;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notesview);
        NotesEditText = findViewById(R.id.NotesEditText);
        final Bundle extras = getIntent().getExtras();
        String text1 = extras.getString("101") ;
        NotesEditText.setText(text1);
        SaveBut = findViewById(R.id.SaveBut);
        SaveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extras.putString("101",NotesEditText.getText().toString());
            }
        });



    }


}
