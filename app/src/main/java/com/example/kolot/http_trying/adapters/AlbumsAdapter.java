package com.example.kolot.http_trying.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kolot.http_trying.R;
import com.example.kolot.http_trying.networking.dto.AlbumsDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kolot on 19.10.2017.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder> {
    public interface ItemClickListener {
        void onClick(AlbumsDTO albumsDTO,int position);
    }

    private List<AlbumsDTO> albums = new ArrayList<>();

    private ItemClickListener itemClickListener;

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AlbumViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final AlbumViewHolder holder, final int position) {
        final AlbumsDTO holderAlbums = albums.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(holderAlbums,position);
            }
        });
        holder.textView.setText(holderAlbums.getTitle());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setAlbums(List<AlbumsDTO> albums) {
        this.albums = albums;
    }
}
