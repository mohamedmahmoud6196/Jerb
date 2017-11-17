package com.example.m7mdmimo.jerb.domain.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by m7md mimo on 11/10/2017.
 */

public class GuestTodo  extends RealmObject {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String image;

    @SerializedName("created_at")
    private String createdDate;
    @SerializedName("updated_at")
    private String updatedDate;

    public GuestTodo() {
    }

    public GuestTodo(int id, String title, String image, String createdDate, String updatedDate) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }
}
