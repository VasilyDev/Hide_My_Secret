package ru.mirotvortsev.hidemysecret;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static ru.mirotvortsev.hidemysecret.R.string.warning_fill_fields;

public class CreateNote extends Activity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private NotesDBHelper dbHelper;
    private SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        dbHelper = new NotesDBHelper(this);
        database = dbHelper.getWritableDatabase();
    }


    public void onClickSaveNote(View view) {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        if (isFilled(title, description)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(NotesContract.NotesEntry.COLUMN_TITLE, title);
            contentValues.put(NotesContract.NotesEntry.COLUMN_DESCRIPTION, description);
            database.insert(NotesContract.NotesEntry.TABLE_NAME, null, contentValues);
            Intent intent = new Intent(this, ViewNotes.class);
            //ViewNotes.notes.add(note);
            startActivity(intent);
            Toast.makeText(this, "It's a one-way road, you'll never see your secret again", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, warning_fill_fields, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isFilled(String title, String description) {
        return !title.isEmpty() && !description.isEmpty();
    }

}