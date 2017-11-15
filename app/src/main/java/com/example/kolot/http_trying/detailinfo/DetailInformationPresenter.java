package com.example.kolot.http_trying.detailinfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.example.kolot.http_trying.networking.DataSource;
import com.example.kolot.http_trying.networking.dto.ImagesDTO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Time;
import java.util.List;


/**
 * Created by kolot on 22.10.2017.
 */

public class DetailInformationPresenter implements DataSource.DataSourceInteractor<List<ImagesDTO>> {
    private DetailView view;
    private DataSource dataSource;


    public DetailInformationPresenter() {
        dataSource = new DataSource();
    }

    public void bindView(DetailView detailView) {
        this.view = detailView;
        view.showProcess();
        int position = view.getNumberAndBody();
        dataSource.getImagesForUser(position, this);
    }

    public void clickBack(){
        view.clickBackButton();
    }

    @Override
    public void onData(List<ImagesDTO> imagesDTOs) {
        view.setImages(imagesDTOs.get(0).getUrls().getRegular());
        view.saveImagesPicasso(imagesDTOs.get(0).getUrls().getRegular());
        view.hideProcess();
    }

    @Override
    public void onError(String message) {
        view.showMessage("Sorry");
        view.hideProcess();
    }




}
