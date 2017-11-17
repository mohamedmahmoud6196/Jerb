package com.example.m7mdmimo.jerb.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by m7md mimo on 11/10/2017.
 */

public abstract class Response {
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
