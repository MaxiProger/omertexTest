package com.example.kolot.http_trying.networking;

import com.example.kolot.http_trying.networking.dto.AlbumsDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kolot on 19.10.2017.
 */

public interface Api {
    @GET("/posts")
    Call<List<AlbumsDTO>> albumsForUser ();
}
