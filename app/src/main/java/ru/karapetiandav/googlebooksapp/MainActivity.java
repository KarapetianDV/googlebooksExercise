package ru.karapetiandav.googlebooksapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.List;

import ru.karapetiandav.googlebooksapp.rest.Item;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Item>> {

    private static final String TAG = MainActivity.class.getSimpleName();
    private int BOOK_QUERY_LOADER_ID = 1;

    private ShimmerRecyclerView mRecyclerView;
    private BookAdapter mRecyclerAdapter;
    private Toolbar toolbar;
    private EditText searchEditText;
    private TextView emptyView_text;
    private String QUERY_BUNDLE_KEY = "query";
    private boolean mHaveOfflineData = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (ShimmerRecyclerView) findViewById(R.id.recyclerView);
        searchEditText = (EditText) findViewById(R.id.searchEditText);

        emptyView_text = (TextView) findViewById(R.id.emptyView_text);
        emptyView_text.setVisibility(View.GONE);

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        addDivider(layoutManager);
        mRecyclerAdapter = new BookAdapter(this);
        mRecyclerView.setAdapter(mRecyclerAdapter);

        // При повороте экрана, bundle != null, мы снова вызываем loader
        // с уже готовыми данными
        if (savedInstanceState != null) {
            if (getSupportLoaderManager().getLoader(BOOK_QUERY_LOADER_ID) != null) {
                getSupportLoaderManager().initLoader(BOOK_QUERY_LOADER_ID, null, this);
                mHaveOfflineData = true;
            }
        }

        if (isConnected()) {
            emptyView_text.setVisibility(View.VISIBLE);
            emptyView_text.setText(R.string.start_hint_text);
        } else {
            if (!mHaveOfflineData) {
                showConnSnackbar();
            }
        }
    }

    private void showConnSnackbar() {
        emptyView_text.setVisibility(View.VISIBLE);
        emptyView_text.setText(R.string.no_internet_text);
        Snackbar.make(mRecyclerView, R.string.no_internet_text, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.snackbar_tryagain_text, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isConnected()) {
                            emptyView_text.setText(R.string.start_hint_text);
                        } else {
                            showConnSnackbar();
                        }
                    }
                })
                .show();
    }

    @Override
    public Loader<List<Item>> onCreateLoader(int id, Bundle args) {
        String query = "";
        if (args != null && !args.isEmpty()) {
            query = args.getString(QUERY_BUNDLE_KEY);
        }
        emptyView_text.setVisibility(View.GONE);

        return new BookLoader(this, query);
    }

    @Override
    public void onLoadFinished(Loader<List<Item>> loader, List<Item> data) {
        mRecyclerView.hideShimmerAdapter();

        if (data != null && data.size() > 0) {
            mRecyclerAdapter.clear();
            mRecyclerAdapter.addAll(data);
        }

        if (isConnected()) {
            if (data.size() == 0) {
                Toast.makeText(this, R.string.data_empty_text, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, R.string.conn_lost_text, Toast.LENGTH_SHORT).show();
        }

        emptyView_text.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(Loader<List<Item>> loader) {
        mRecyclerAdapter.clear();
    }


    public void onSearchButtonClick(View view) {
        String query = searchEditText.getText().toString().trim();
        if (!TextUtils.isEmpty(query) && isConnected()) {
            Bundle inLoader = new Bundle();
            inLoader.putString(QUERY_BUNDLE_KEY, query);
            getSupportLoaderManager().restartLoader(BOOK_QUERY_LOADER_ID, inLoader, this);
            mRecyclerView.showShimmerAdapter();
        }
    }

    private void addDivider(LinearLayoutManager layoutManager) {
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(mRecyclerView.getContext(), layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
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
