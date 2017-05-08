package ru.karapetiandav.googlebooksapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Book>> {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String GOOGLE_BOOKS_API_URL = "https://www.googleapis.com/books/v1/volumes";
    private int BOOK_QUERY_LOADER_ID = 1;

    private ListView listView;
    private BookAdapter bookAdapter;
    private ProgressBar progressBar;
    private Toolbar toolbar;
    private EditText searchEditText;
    private TextView emptyView_text;
    private String QUERY_BUNDLE_KEY = "query";

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

        emptyView_text = (TextView) findViewById(R.id.emptyView_text);
        listView.setEmptyView(emptyView_text);

        if (isConnected()) {
            progressBar.setVisibility(View.GONE);
            emptyView_text.setText(R.string.start_hint_text);
        } else {
            progressBar.setVisibility(View.GONE);
            emptyView_text.setText(R.string.no_internet_text);
            Snackbar.make(listView, R.string.no_internet_text, Snackbar.LENGTH_INDEFINITE)
                    .setAction("Refresh", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle inLoader = new Bundle();
                            inLoader.putString(QUERY_BUNDLE_KEY, searchEditText.getText().toString());
                            getSupportLoaderManager().restartLoader(BOOK_QUERY_LOADER_ID, inLoader, MainActivity.this);
                        }
                    })
                    .show();
        }
    }

    @Override
    public Loader<ArrayList<Book>> onCreateLoader(int id, Bundle args) {
        Uri baseUri = Uri.parse(GOOGLE_BOOKS_API_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        String query = "";
        if (args != null && !args.isEmpty()) {
            query = args.getString(QUERY_BUNDLE_KEY);
        }

        uriBuilder.appendQueryParameter("q", query);
        uriBuilder.appendQueryParameter("maxResults", "20");

        emptyView_text.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        return new BookLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Book>> loader, ArrayList<Book> data) {
        bookAdapter.clear();

        if (data != null && !data.isEmpty())
            bookAdapter.addAll(data);

        progressBar.setVisibility(View.GONE);
        emptyView_text.setVisibility(View.GONE);
        listView.setAdapter(bookAdapter);
        Log.d(TAG, "onLoadFinished: ");
    }


    @Override
    public void onLoaderReset(Loader<ArrayList<Book>> loader) {
        bookAdapter.clear();
    }

    public void onSearchButtonClick(View view) {
        Bundle inLoader = new Bundle();
        inLoader.putString(QUERY_BUNDLE_KEY, searchEditText.getText().toString());
        getSupportLoaderManager().restartLoader(BOOK_QUERY_LOADER_ID, inLoader, this);
    }

    private boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {
            boolean isConnected = activeNetwork.isConnectedOrConnecting();
            return isConnected;
        }

        return false;
    }
}
