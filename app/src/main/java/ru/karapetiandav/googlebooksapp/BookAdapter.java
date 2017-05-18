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

import ru.karapetiandav.googlebooksapp.rest.Item;
import ru.karapetiandav.googlebooksapp.rest.VolumeInfo;

import static ru.karapetiandav.googlebooksapp.BookUtils.extractAuthors;


public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private static final String TAG = BookAdapter.class.getSimpleName();
    private Context mContext;
    private List<Item> mBookItems = new ArrayList<>();

    public BookAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View bookView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(bookView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item book = mBookItems.get(position);
        VolumeInfo info = book.getVolumeInfo();

        ImageView bookImage = holder.mBookImage;

        // TODO: Create placeholder, error
        Picasso
                .with(mContext)
                .load(info.getImageLinks().getSmallThumbnailUrl())
                .fit()
                .into(bookImage);

        TextView bookTitle = holder.mBookTitle;
        bookTitle.setText(info.getTitle());

        TextView bookAuthor = holder.mBookAuthors;
        bookAuthor.setText(extractAuthors(info.getAuthors()));
    }

    @Override
    public int getItemCount() {
        return mBookItems.size();
    }

    public void clear() {
        mBookItems.clear();
        notifyItemRangeChanged(0, mBookItems.size());
    }

    public void addAll(List<Item> data) {
        mBookItems = data;
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