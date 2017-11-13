package com.example.kolot.http_trying.main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.kolot.http_trying.R;
import com.example.kolot.http_trying.adapters.AlbumsAdapter;
import com.example.kolot.http_trying.detailinfo.DetailInformarionActivity;
import com.example.kolot.http_trying.networking.dto.AlbumsDTO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private RecyclerView recyclerView;
    private AlbumsAdapter albumsAdapter;
    private MainPresenter presenter;
    private ProgressDialog progressDialog;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter();

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                List<AlbumsDTO> albums = new ArrayList<AlbumsDTO>();
                presenter.refresh(albums);
            }
        });

        albumsAdapter = new AlbumsAdapter();
        recyclerView.setAdapter(albumsAdapter);

        albumsAdapter.setItemClickListener(new AlbumsAdapter.ItemClickListener() {

            @Override
            public void onClick(AlbumsDTO albumsDTO, int position) {
                presenter.itemClicked(albumsDTO, position);
            }
        });

        presenter.bindView(this);
    }

    @Override
    public void showDetailsInformationView(AlbumsDTO albumsDTO, int position) {
        Intent intent = new Intent(this, DetailInformarionActivity.class);
        intent.putExtra("id", position);
        intent.putExtra("body", albumsDTO.getBody());
        startActivity(intent);
    }

    @Override
    public void setAlbums(List<AlbumsDTO> albums) {
        albumsAdapter.setAlbums(albums);
    }

    @Override
    public void notifyAdapter() {
        albumsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProcess() {
        progressDialog = ProgressDialog.show(this, "", "Please wait...");
    }

    @Override
    public void hideProcess() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshRecyclerView(List<AlbumsDTO> albums) {
        recyclerView.setAdapter(albumsAdapter);

        albumsAdapter.setItemClickListener(new AlbumsAdapter.ItemClickListener() {

            @Override
            public void onClick(AlbumsDTO albumsDTO, int position) {
                presenter.itemClicked(albumsDTO, position);
            }
        });

        presenter.bindView(this);
        setAlbums(albums);
        notifyAdapter();
        presenter.onData(albums);
    }

    @Override
    public void onRefreshCompleted() {
        swipeRefreshLayout.setRefreshing(false);
    }


}
