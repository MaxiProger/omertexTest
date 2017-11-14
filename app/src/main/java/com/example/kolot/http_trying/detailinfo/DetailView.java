package com.example.kolot.http_trying.detailinfo;

import android.widget.ImageView;

/**
 * Created by kolot on 22.10.2017.
 */

public interface DetailView {
    void setImages(String url);
    void showProcess();
    void hideProcess();
    void saveImages (ImageView iv, String folder);
    void showMessage(String message);
    int getNumberAndBody();
    void clickBackButton();
}
