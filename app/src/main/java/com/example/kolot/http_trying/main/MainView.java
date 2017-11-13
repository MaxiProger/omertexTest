package com.example.kolot.http_trying.main;

import com.example.kolot.http_trying.networking.dto.AlbumsDTO;

import java.util.List;

/**
 * Created by kolot on 22.10.2017.
 */

public interface MainView {
    void showDetailsInformationView(AlbumsDTO albumsDTO, int position);
    void setAlbums(List<AlbumsDTO> albums);
    void notifyAdapter();
    void showProcess();
    void hideProcess();
    void showMessage(String message);
    void refreshRecyclerView(List<AlbumsDTO> albums);
    void onRefreshCompleted ();
}
