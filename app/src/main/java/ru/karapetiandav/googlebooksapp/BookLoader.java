package ru.karapetiandav.googlebooksapp;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;


public class BookLoader extends AsyncTaskLoader<ArrayList<Book>> {

    private static final String TAG = BookLoader.class.getSimpleName();
    private final String url;

    public BookLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        onForceLoad();
    }

    @Override
    public ArrayList<Book> loadInBackground() {
        if (url != null && url.length() > 0) {
            return BookUtils.extractBooks(url);
        } else {
            return null;
        }
    }
}
