package com.zerobytes.sanju.notesapp.async;

import android.os.AsyncTask;

import com.zerobytes.sanju.notesapp.models.Note;
import com.zerobytes.sanju.notesapp.persistence.NoteDao;

public class UpdateAsyncTask extends AsyncTask<Note, Void, Void> {

    private NoteDao mNoteDao;

    public UpdateAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.updateNotes(notes);
        return null;
    }

}