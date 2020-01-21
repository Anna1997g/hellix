package com.example.taskexample.network.entities;

import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class Video implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumbnailUrl")
    @Expose
    private String thumbnailUrl;
    @SerializedName("youtubeId")
    @Expose
    private String youtubeId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(title, video.title) &&
                Objects.equals(thumbnailUrl, video.thumbnailUrl) &&
                Objects.equals(youtubeId, video.youtubeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, thumbnailUrl, youtubeId);
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", youtubeId='" + youtubeId + '\'' +
                '}';
    }
}
