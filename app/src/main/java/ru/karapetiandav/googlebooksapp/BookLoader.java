package ru.karapetiandav.googlebooksapp;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;
import ru.karapetiandav.googlebooksapp.rest.Book;
import ru.karapetiandav.googlebooksapp.rest.Item;


public class BookLoader extends AsyncTaskLoader<List<Item>> {

    private static final String TAG = BookLoader.class.getSimpleName();
    private String query;
    private int DEFAULT_MAX_RESULTS = 20;

    public BookLoader(Context context, String query) {
        super(context);

        this.query = query;
    }

    @Override
    protected void onStartLoading() {
        onForceLoad();
    }

    @Override
    public List<Item> loadInBackground() {
        List<Item> result = new ArrayList<>();

        try {
            Response<Book> response = App.getApiService().getBooks(query, DEFAULT_MAX_RESULTS).execute();
            result = response.body().getItems();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
