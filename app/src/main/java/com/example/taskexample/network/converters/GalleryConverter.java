package com.example.taskexample.network.converters;

import androidx.room.TypeConverter;

import com.example.taskexample.network.entities.Gallery;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public  class GalleryConverter {
    @TypeConverter
    public String fromGalleryList(List<Gallery> galleries) {
        if (galleries == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Gallery>>() {
        }.getType();
        String json = gson.toJson(galleries, type);
        return json;
    }

    @TypeConverter
    public List<Gallery> toGalleryList(String galleryString) {
        if (galleryString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Gallery>>() {
        }.getType();
        List<Gallery> galleriesList = gson.fromJson(galleryString, type);
        return galleriesList;
    }
}
