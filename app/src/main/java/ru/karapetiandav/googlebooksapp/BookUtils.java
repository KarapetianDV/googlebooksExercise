package ru.karapetiandav.googlebooksapp;

import java.util.List;

public class BookUtils {

    private static final String TAG = BookUtils.class.getSimpleName();

    private BookUtils() {
    }

    public static String extractAuthors(List<String> authors) {
        StringBuilder builder = new StringBuilder();
        String delim = "";
        for (String author : authors) {
            builder.append(delim).append(author);
            delim = ", ";
        }

        return builder.toString();
    }
}
