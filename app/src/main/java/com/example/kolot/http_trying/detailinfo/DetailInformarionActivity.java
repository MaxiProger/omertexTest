package com.example.kolot.http_trying.detailinfo;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kolot.http_trying.R;
import com.example.kolot.http_trying.editor.EditorActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DetailInformarionActivity extends AppCompatActivity implements DetailView {
    private ImageView imageView;
    private TextView description;
    private ProgressBar progressBar;
    private Toolbar toolbar;
    private DetailInformationPresenter presenter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_informarion);

        presenter = new DetailInformationPresenter();
        imageView = (ImageView) findViewById(R.id.imageView);
        description = (TextView) findViewById(R.id.description);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        button = (Button) findViewById(R.id.button);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(DetailInformarionActivity.this, EditorActivity.class);
        startActivity(intent);
    }
});

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickBack();
            }
        });
        presenter.bindView(this);


    }

    @Override
    public void setImages(String url) {
        Picasso.with(this).load(url).into(imageView);

    }

    private Target picassoImageTarget(Context context, final String imageDir, final String imageName) {
        Log.d("picassoImageTarget", " picassoImageTarget");
        ContextWrapper cw = new ContextWrapper(context);
        final File directory = cw.getDir(imageDir, Context.MODE_PRIVATE); // path to /data/data/yourapp/app_imageDir
        return new Target() {
            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final File myImageFile = new File(directory, imageName); // Create image file
                        FileOutputStream fos = null;
                        try {
                            fos = new FileOutputStream(myImageFile);
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.i("image", "image saved to >>>" + myImageFile.getAbsolutePath());

                    }
                }).start();
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
            }
            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                if (placeHolderDrawable != null) {}
            }
        };
    }

    public void saveImagesPicasso(String url) {
        Picasso.with(this).load(url).into(picassoImageTarget(getApplicationContext(), "imageDir", "asdasd.jpeg"));
    }

    @Override
    public void showProcess() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProcess() {
        progressBar.setVisibility(View.GONE);
    }




    @Override
    public void showMessage(String message) {
        Toast.makeText(DetailInformarionActivity.this, "Sorry", Toast.LENGTH_LONG).show();
    }

    @Override
    public int getNumberAndBody() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        description.setText(intent.getStringExtra("body").toString());
        return id;
    }

    @Override
    public void clickBackButton() {
        finish();
    }


}
