package ru.mirotvortsev.hidemysecret;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private final ArrayList<SecretNote> notes;
    //создадим в нашем адаптере объект нашего слушателя
    private onNoteClickListener onNoteClickListener;

    public NotesAdapter(ArrayList<SecretNote> notes) {
        this.notes = notes;
    }

    public void setOnNoteClickListener(NotesAdapter.onNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
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

    //создаём интерфейс будет слушать щелчки на элементы
    interface onNoteClickListener {
        void onNoteClick(int position);

        void onLongClick(int position);
    }

    static class NotesViewHolder extends RecyclerView.ViewHolder {

        private final EditText editTextTitle;
        private final EditText editTextDescription;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            editTextTitle = itemView.findViewById(R.id.editTextTitle);
            editTextDescription = itemView.findViewById(R.id.editTextDescription);

        }
    }
}