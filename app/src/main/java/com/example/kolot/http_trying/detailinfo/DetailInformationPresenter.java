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
        view.hideProcess();
    }

    @Override
    public void onError(String message) {
        view.showMessage("Sorry");
        view.hideProcess();
    }


    public String SavePicture(ImageView iv, String folderToSave)
    {
        OutputStream fOut = null;
        Time time = new Time (15, 12,5);


        try {
            File file = new File(folderToSave, Integer.toString(time.getYear()) +
                    Integer.toString(time.getMonth()+1) + Integer.toString(time.getDay()) +
                    Integer.toString(time.getHours()) + Integer.toString(time.getMinutes()) +
                    Integer.toString(time.getSeconds()) +".jpg"); // создать уникальное имя для файла основываясь на дате сохранения
            fOut = new FileOutputStream(file);

            Drawable drawable = iv.getDrawable();
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fOut); // сохранять картинку в jpeg-формате с 85% сжатия.
            fOut.flush();
            fOut.close();
/*
            MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(),  file.getName()); // регистрация в фотоальбоме
*/
        }
        catch (Exception e) // здесь необходим блок отслеживания реальных ошибок и исключений, общий Exception приведен в качестве примера
        {
            return e.getMessage();
        }
        return "";
    }
}
