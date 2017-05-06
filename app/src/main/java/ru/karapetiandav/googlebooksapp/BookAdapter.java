package ru.karapetiandav.googlebooksapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem = convertView;
        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Book currentBook = getItem(position);

        TextView author = (TextView) listViewItem.findViewById(R.id.author);
        TextView title = (TextView) listViewItem.findViewById(R.id.title);

        if (currentBook != null) {
            author.setText(currentBook.getAuthor());
            title.setText(currentBook.getTitle());
        }

        return listViewItem;
    }
}
