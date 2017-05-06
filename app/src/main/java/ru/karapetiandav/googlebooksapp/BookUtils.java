package ru.karapetiandav.googlebooksapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class BookUtils {

    private BookUtils() {
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String json = "";

        if (url == null) {
            return json;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                json = readFromStream(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return json;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
        }

        return output.toString();
    }

    public static ArrayList<Book> extractBooks(String url) {
        ArrayList<Book> books = new ArrayList<>();

        try {
            // TODO: переделать обратно
            JSONObject root = new JSONObject(url);
            JSONArray items = root.getJSONArray("items");

            for (int i = 0; i < items.length(); i++) {
                JSONObject book = items.getJSONObject(i);

                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                String title = volumeInfo.getString("title");
                JSONArray authors = volumeInfo.getJSONArray("authors");

                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < authors.length(); j++) {
                    if (authors.length() == j)
                        builder.append(authors.get(j));

                    if (authors.length() < j)
                        builder.append(authors.get(j)).append(", ");
                }
                String author = builder.toString();

                JSONArray imageLinks = volumeInfo.getJSONArray("imageLinks");
                String smallThumbnailUrl = imageLinks.getString(0);

                books.add(new Book(title, author, smallThumbnailUrl));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        return books;
    }
}
