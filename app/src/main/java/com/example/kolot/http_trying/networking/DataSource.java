package com.example.kolot.http_trying.networking;

import com.example.kolot.http_trying.networking.dto.AlbumsDTO;
import com.example.kolot.http_trying.networking.dto.ImagesDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kolot on 22.10.2017.
 */

public class DataSource {
    public interface DataSourceInteractor<T> {
        void onData(T albumsDTOs);
        void onError(String message);
    }



    private Api api;
    public final static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private ApiImages apiImages;
    public final static String BASE_URL_IMAGES = "https://api.unsplash.com/";

    public DataSource() {
        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        api = retrofit.create(Api.class);


        Retrofit.Builder builderImages = new Retrofit.Builder()
                .baseUrl(BASE_URL_IMAGES)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofitImages = builderImages.build();
        apiImages = retrofitImages.create(ApiImages.class);
    }

    public void getAlbumsForUser(final DataSourceInteractor<List<AlbumsDTO>> dataSourceInteractor) {
        api.albumsForUser().enqueue(new Callback<List<AlbumsDTO>>() {
            @Override
            public void onResponse(Call<List<AlbumsDTO>> call, Response<List<AlbumsDTO>> response) {
                dataSourceInteractor.onData(response.body());
            }

            @Override
            public void onFailure(Call<List<AlbumsDTO>> call, Throwable t) {
                dataSourceInteractor.onError(t.getMessage());
            }
        });
    }

    public void getImagesForUser(int position, final DataSourceInteractor<List<ImagesDTO>> dataSourceImagesInteractor){
        apiImages.imagesForUser(position).enqueue(new Callback<List<ImagesDTO>>() {
            @Override
            public void onResponse(Call<List<ImagesDTO>> call, Response<List<ImagesDTO>> response) {
                dataSourceImagesInteractor.onData(response.body());
            }

            @Override
            public void onFailure(Call<List<ImagesDTO>> call, Throwable t) {
                dataSourceImagesInteractor.onError(t.getMessage());
            }
        });
    }

}
