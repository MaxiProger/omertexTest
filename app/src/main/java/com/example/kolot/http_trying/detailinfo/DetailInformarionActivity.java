package com.example.kolot.http_trying.detailinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kolot.http_trying.R;
import com.squareup.picasso.Picasso;

public class DetailInformarionActivity extends AppCompatActivity implements DetailView {
    private ImageView imageView;
    private TextView description;
    private ProgressBar progressBar;
    private Toolbar toolbar;
    private DetailInformationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_informarion);

        presenter = new DetailInformationPresenter();
        imageView = (ImageView) findViewById(R.id.imageView);
        description = (TextView) findViewById(R.id.description);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        toolbar = (Toolbar) findViewById(R.id.toolBar);

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
