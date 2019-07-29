package com.zerobytes.sanju.notesapp.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.zerobytes.sanju.notesapp.async.DeleteAsyncTask;
import com.zerobytes.sanju.notesapp.async.InsertAsyncTask;
import com.zerobytes.sanju.notesapp.async.UpdateAsyncTask;
import com.zerobytes.sanju.notesapp.models.Note;

import java.util.List;

public class NoteRepository {

    private NoteDatabase mNoteDatabase;

    public NoteRepository(Context context) {
        this.mNoteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertNoteTask(Note note){
        new InsertAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }

    public void updateNoteTask(Note note){
        new UpdateAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }

    public LiveData<List<Note>> retrieveNotesTask() {
        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNoteTask(Note note){
        new DeleteAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }
}
