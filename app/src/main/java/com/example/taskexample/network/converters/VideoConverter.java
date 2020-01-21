package com.example.taskexample.network.converters;

import androidx.room.TypeConverter;

import com.example.taskexample.network.entities.Video;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class VideoConverter {
    @TypeConverter
    public String fromVideoList(List<Video> videos) {
        if (videos == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Video>>() {
        }.getType();
        return gson.toJson(videos, type);
    }

    @TypeConverter
    public List<Video> toVideoList(String videoString) {
        if (videoString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Video>>() {
        }.getType();
        return gson.fromJson(videoString, type);
    }
}
