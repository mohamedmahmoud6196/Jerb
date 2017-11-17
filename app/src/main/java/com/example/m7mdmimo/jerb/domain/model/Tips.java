package com.example.m7mdmimo.jerb.domain.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by m7md mimo on 11/10/2017.
 */

public class Tips extends RealmObject {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String imagePath;
    @SerializedName("active")
    private String active;
    @SerializedName("created_at")
    private String createdDate;

    public Tips() {
    }

    public Tips(int id, String title, String imagePath, String active, String createdDate, String updatedDate) {
        this.id = id;
        this.title = title;
        this.imagePath = imagePath;
        this.active = active;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getActive() {

        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @SerializedName("updated_at")
    private String updatedDate;

    public Tips(int id, String data) {
        this.id = id;
        this.title = data;
    }

    public int
    getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Tips(int id, String data, String imagePath) {

        this.id = id;
        this.title = data;
        this.imagePath = imagePath;
    }

}
