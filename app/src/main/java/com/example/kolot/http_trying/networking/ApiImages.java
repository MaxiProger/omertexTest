package com.example.kolot.http_trying.networking;

import com.example.kolot.http_trying.networking.dto.ImagesDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kolot on 21.10.2017.
 */

public interface ApiImages {

    @GET("/photos?per_page=1&client_id=8938f99e90409d2ffbd5282aadeeae24e799f50aa336d9fa11f300be235e6015")
    Call<List<ImagesDTO>> imagesForUser (
            @Query("page") int page);
}
