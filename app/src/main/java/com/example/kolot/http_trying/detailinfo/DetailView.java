package com.example.kolot.http_trying.detailinfo;

/**
 * Created by kolot on 22.10.2017.
 */

public interface DetailView {
    void setImages(String url);
    void showProcess();
    void hideProcess();
    void showMessage(String message);
    void saveImagesPicasso(String url);
    int getNumberAndBody();
    void clickBackButton();
    void hideButton();
    void showButton();
}
