package ru.karapetiandav.googlebooksapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.karapetiandav.googlebooksapp.rest.Book;

public interface GoogleBooksClient {

    @GET("/books/v1/volumes")
    Call<Book> getBooks(@Query("q") String bookName, @Query("maxResults") int maxResults);
}
