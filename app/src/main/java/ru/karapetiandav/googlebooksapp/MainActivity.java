package ru.karapetiandav.googlebooksapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Book>> {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String GOOGLE_BOOKS_URL = "https://www.googleapis.com/books/v1/volumes";
    private ListView listView;
    private BookAdapter bookAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        bookAdapter = new BookAdapter(this, R.layout.list_item);
        getSupportLoaderManager().initLoader(1, null, this);

        listView.setAdapter(bookAdapter);
    }

    @Override
    public Loader<ArrayList<Book>> onCreateLoader(int id, Bundle args) {
        Uri baseUri = Uri.parse(GOOGLE_BOOKS_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        uriBuilder.appendQueryParameter("q", "Hello");
        uriBuilder.appendQueryParameter("maxResults", "20");

        return new BookLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Book>> loader, ArrayList<Book> data) {
        if (data != null && !data.isEmpty())
            bookAdapter.addAll(data);
        progressBar.setVisibility(View.GONE);
        listView.setAdapter(bookAdapter);
        Log.d(TAG, "onLoadFinished: ");
    }


    @Override
    public void onLoaderReset(Loader<ArrayList<Book>> loader) {
        bookAdapter.clear();
    }
}
