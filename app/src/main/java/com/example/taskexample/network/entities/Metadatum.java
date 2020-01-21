package com.example.taskexample.network.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.taskexample.network.converters.GalleryConverter;
import com.example.taskexample.network.converters.VideoConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity(tableName = "metadatums")
public class Metadatum implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private Boolean isSeen = false;
    @ColumnInfo
    @SerializedName("category")
    @Expose
    private String category;
    @ColumnInfo
    @SerializedName("title")
    @Expose
    private String title;
    @ColumnInfo
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("shareUrl")
    @Expose
    private String shareUrl;
    @ColumnInfo
    @SerializedName("coverPhotoUrl")
    @Expose
    private String coverPhotoUrl;
    @ColumnInfo
    @SerializedName("date")
    @Expose
    private Integer date;
    @TypeConverters(GalleryConverter.class)
    @SerializedName("gallery")
    @Expose
    private List<Gallery> gallery = null;
    @TypeConverters(VideoConverter.class)
    @SerializedName("video")
    @Expose
    private List<Video> video = null;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public List<Gallery> getGallery() {
        return gallery;
    }

    public void setGallery(List<Gallery> gallery) {
        this.gallery = gallery;
    }

    public List<Video> getVideo() {
        return video;
    }

    public void setVideo(List<Video> video) {
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Boolean getSeen() {
        return isSeen;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metadatum metadatum = (Metadatum) o;
        return
                Objects.equals(category, metadatum.category) &&
                Objects.equals(title, metadatum.title) &&
                Objects.equals(body, metadatum.body) &&
                Objects.equals(shareUrl, metadatum.shareUrl) &&
                Objects.equals(coverPhotoUrl, metadatum.coverPhotoUrl) &&
                Objects.equals(date, metadatum.date) &&
                Objects.equals(gallery, metadatum.gallery) &&
                Objects.equals(video, metadatum.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, title, body, shareUrl, coverPhotoUrl, date, gallery, video);
    }

    @Override
    public String toString() {
        return "Metadatum{" +
                "id=" + id +
                ", isSeen=" + isSeen +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                ", date=" + date +
                ", gallery=" + gallery +
                ", video=" + video +
                '}';
    }
}

