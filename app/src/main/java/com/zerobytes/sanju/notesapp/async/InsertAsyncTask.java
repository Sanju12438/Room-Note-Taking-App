package com.zerobytes.sanju.notesapp.async;

import android.os.AsyncTask;

import com.zerobytes.sanju.notesapp.models.Note;
import com.zerobytes.sanju.notesapp.persistence.NoteDao;

public class InsertAsyncTask extends AsyncTask<Note, Void, Void> {

    private NoteDao mNoteDao;

    public InsertAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.insertNotes(notes);
        return null;
    }

}