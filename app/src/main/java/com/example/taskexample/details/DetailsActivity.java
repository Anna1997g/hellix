package com.example.taskexample.details;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taskexample.R;
import com.example.taskexample.details.gallery.GalleryActivity;
import com.example.taskexample.details.video.VideoActivity;
import com.example.taskexample.main.activities.MainActivity;
import com.example.taskexample.network.entities.Gallery;
import com.example.taskexample.network.entities.Metadatum;
import com.example.taskexample.network.entities.Video;
import com.example.taskexample.utils.DateUtils;
import com.example.taskexample.utils.StringUtils;
import com.example.taskexample.utils.utils_glide.GlideUtils;

import java.io.Serializable;
import java.util.List;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String YOUTUBE_ID_KEY = "youtubeid";
    public static final String GALLERY_KEY = "Gallery";


    private List<Gallery> galleryList;
    private List<Video> videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView tvDetailsTitle = findViewById(R.id.tv_details_title);
        TextView tvDetailsCategory = findViewById(R.id.tv_details_category);
        TextView tvDetailsDate = findViewById(R.id.tv_details_date);
        TextView tvDetailsBody = findViewById(R.id.tv_details_body);
        ImageView ivDetailsImage = findViewById(R.id.iv_details_image);
        ImageView ivGallery = findViewById(R.id.iv_gallery);
        ImageView ivVideo = findViewById(R.id.iv_video);
        ImageView ivClose = findViewById(R.id.iv_close);
        ivVideo.setOnClickListener(this);
        ivGallery.setOnClickListener(this);
        ivClose.setOnClickListener(this);


        Intent intent = getIntent();


        Metadatum metadatum = (Metadatum) intent.getSerializableExtra(MainActivity.METADATUM);
        if (metadatum == null)
            return;
        tvDetailsTitle.setText(metadatum.getTitle());
        tvDetailsCategory.setText(metadatum.getCategory());
//        tvDetailsBody.setText(StringUtils.replaceCustomFromHtml(metadatum.getBody()));
        tvDetailsDate.setText(DateUtils.setDate(metadatum.getDate().toString()));
        tvDetailsBody.setText(Html.fromHtml(metadatum.getBody()));
        GlideUtils.setFitCenterImage(ivDetailsImage, metadatum.getCoverPhotoUrl());
        galleryList = metadatum.getGallery();
        videoList = metadatum.getVideo();

        if (videoList != null)
            ivVideo.setVisibility(View.VISIBLE);
        if (galleryList != null)
            ivGallery.setVisibility(View.VISIBLE);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_video:
                Intent intent1 = new Intent(DetailsActivity.this, VideoActivity.class);
                intent1.putExtra(YOUTUBE_ID_KEY, videoList.get(0).getYoutubeId());
                startActivity(intent1);
                break;
            case R.id.iv_gallery:
                Intent intent = new Intent(DetailsActivity.this, GalleryActivity.class);
                intent.putExtra(GALLERY_KEY, (Serializable) galleryList);
                startActivity(intent);
                break;
            case R.id.iv_close:
                finish();
                break;
            default:
                break;
        }
    }
}
