package com.shivam.giphyme.view.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shivam.giphyme.R;
import com.shivam.giphyme.model.Data;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GifAdaptor extends RecyclerView.Adapter<GifAdaptor.GifViewHolder> {

    List<Data> data;

    public GifAdaptor(List<Data> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public GifViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gitf_item, parent, false);
        GifViewHolder gifViewHolder = new GifViewHolder(view);
        return gifViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GifViewHolder holder, int position) {
        String url = data.get(position).getImages().getStill480().getUrl();
        Picasso.get().load(url).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    class GifViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public GifViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gif_imageview);
        }
    }
}
