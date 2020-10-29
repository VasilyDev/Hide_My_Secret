package ru.mirotvortsev.hidemysecret;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private ArrayList<SecretNote> notes;

    public NotesAdapter(ArrayList<SecretNote> notes) {
        this.notes = notes;
    }


    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_item, viewGroup, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder notesViewHolder, int i) {
        SecretNote note = notes.get(i);
        notesViewHolder.editTextTitle.setText(note.getTitle());
        notesViewHolder.editTextDescription.setText(note.getDescription());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{

        private EditText editTextTitle;
        private EditText editTextDescription;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            editTextTitle = itemView.findViewById(R.id.editTextTitle);
            editTextDescription = itemView.findViewById(R.id.editTextDescription);
        }
    }
}
