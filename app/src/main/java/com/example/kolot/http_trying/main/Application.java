package com.example.kolot.http_trying.main;

import ly.img.android.PESDK;

/**
 * Created by max on 11/14/17.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PESDK.init(this, "android_license.dms");
    }
}
