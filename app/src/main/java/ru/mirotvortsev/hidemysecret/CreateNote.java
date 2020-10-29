package ru.mirotvortsev.hidemysecret;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateNote extends Activity {
    private EditText editTextTitle;
    private EditText editTextDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
    }


    public void onClickSaveNote(View view) {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        SecretNote note = new SecretNote(title, description);
        ViewNotes.notes.add(note);
        Intent intent = new Intent(this, ViewNotes.class);
        startActivity(intent);
    }
}