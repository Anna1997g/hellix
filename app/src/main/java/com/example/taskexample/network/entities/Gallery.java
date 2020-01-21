package com.example.taskexample.network.entities;

import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class Gallery implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumbnailUrl")
    @Expose
    private String thumbnailUrl;
    @SerializedName("contentUrl")
    @Expose
    private String contentUrl;

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

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gallery gallery = (Gallery) o;
        return Objects.equals(title, gallery.title) &&
                Objects.equals(thumbnailUrl, gallery.thumbnailUrl) &&
                Objects.equals(contentUrl, gallery.contentUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, thumbnailUrl, contentUrl);
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "title='" + title + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", contentUrl='" + contentUrl + '\'' +
                '}';
    }
}
