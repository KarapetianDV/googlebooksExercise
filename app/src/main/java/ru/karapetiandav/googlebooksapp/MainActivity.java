package ru.karapetiandav.googlebooksapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Book>> {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String GOOGLE_BOOKS_API_URL = "https://www.googleapis.com/books/v1/volumes";
    private int BOOK_QUERY_LOADER_ID = 1;
    ;

    private ListView listView;
    private BookAdapter bookAdapter;
    private ProgressBar progressBar;
    private Toolbar toolbar;
    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        searchEditText = (EditText) findViewById(R.id.searchEditText);

        bookAdapter = new BookAdapter(this, R.layout.list_item);
        getSupportLoaderManager().initLoader(BOOK_QUERY_LOADER_ID, null, this);

        listView.setAdapter(bookAdapter);
    }

    @Override
    public Loader<ArrayList<Book>> onCreateLoader(int id, Bundle args) {
        Uri baseUri = Uri.parse(GOOGLE_BOOKS_API_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        String query = "";
        if (args != null && !args.isEmpty())
            query = args.getString("query");

        uriBuilder.appendQueryParameter("q", query);
        uriBuilder.appendQueryParameter("maxResults", "20");

        return new BookLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Book>> loader, ArrayList<Book> data) {
        bookAdapter.clear();

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

    public void onSearchButtonClick(View view) {
        Bundle inLoader = new Bundle();
        inLoader.putString("query", searchEditText.getText().toString());
        getSupportLoaderManager().restartLoader(BOOK_QUERY_LOADER_ID, inLoader, this);
    }
}
