package ru.karapetiandav.googlebooksapp;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static final String BASE_URL = "https://www.googleapis.com/";

    private static GoogleBooksClient apiService;
    private Retrofit retrofit;

    public static GoogleBooksClient getApiService() {
        return apiService;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(GoogleBooksClient.class);
    }
}
