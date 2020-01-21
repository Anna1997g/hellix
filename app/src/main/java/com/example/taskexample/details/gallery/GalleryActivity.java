package com.example.taskexample.details.gallery;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.taskexample.R;
import com.example.taskexample.details.DetailsActivity;
import com.example.taskexample.network.entities.Gallery;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    private List<Gallery> galleryList;
    private ArrayList<String> url = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Intent intent = getIntent();
        galleryList = (List<Gallery>) intent.getSerializableExtra(DetailsActivity.GALLERY_KEY);
        ViewPager viewPager = findViewById(R.id.view_pager);
        initializeUrl();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, url);
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void initializeUrl() {
        for (Gallery gallery : galleryList) {
            url.add(gallery.getThumbnailUrl());
        }
    }

}
