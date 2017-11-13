package com.example.kolot.http_trying.main;

import com.example.kolot.http_trying.networking.DataSource;
import com.example.kolot.http_trying.networking.dto.AlbumsDTO;

import java.util.List;

/**
 * Created by kolot on 22.10.2017.
 */

public class MainPresenter implements DataSource.DataSourceInteractor<List<AlbumsDTO>>{

    private MainView view;
    private DataSource dataSource;

    public MainPresenter() {
        dataSource = new DataSource();
    }

    public void bindView(MainView mainView) {
        this.view = mainView;
        view.showProcess();
        dataSource.getAlbumsForUser(this);
    }


    public void itemClicked(AlbumsDTO albumsDTO, int position) {
        view.showDetailsInformationView(albumsDTO, position);
    }


    @Override
    public void onData(List<AlbumsDTO> albumsDTOs) {
        view.setAlbums(albumsDTOs);
        view.hideProcess();
        view.notifyAdapter();
    }

    @Override
    public void onError(String message) {
        view.showMessage(message);
        view.hideProcess();
    }


    public void refresh(List<AlbumsDTO> albumsDTOs){
        view.refreshRecyclerView(albumsDTOs);
        view.onRefreshCompleted();
    }
}
