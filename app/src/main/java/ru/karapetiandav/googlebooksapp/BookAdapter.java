package ru.karapetiandav.googlebooksapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private Context mContext;
    private List<Book> mBooks = new ArrayList<>();

    public BookAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public BookAdapter(Context context, List<Book> books) {
        this.mContext = context;
        this.mBooks = books;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View bookView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(bookView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mBooks.get(position);

        ImageView bookImage = holder.mBookImage;

        // TODO: Create placeholder, error
        Picasso
                .with(mContext)
                .load(book.getImageUrl())
                .into(bookImage);

        TextView bookTitle = holder.mBookTitle;
        bookTitle.setText(book.getTitle());

        TextView bookAuthor = holder.mBookAuthors;
        bookAuthor.setText(book.getAuthor());
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public void clear() {
        mBooks.clear();
        notifyItemRangeChanged(0, mBooks.size());
    }

    public void addAll(List<Book> data) {
        mBooks = data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mBookImage;
        public TextView mBookTitle;
        public TextView mBookAuthors;

        public ViewHolder(View itemView) {
            super(itemView);

            this.mBookImage = (ImageView) itemView.findViewById(R.id.book_image);
            this.mBookTitle = (TextView) itemView.findViewById(R.id.book_title);
            this.mBookAuthors = (TextView) itemView.findViewById(R.id.book_author);
        }
    }
}
