package com.example.m7mdmimo.jerb.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by m7md mimo on 11/10/2017.
 */

public class TipsResponse extends Response {

    @SerializedName("data")
    @Expose
    private ArrayList<Tips> tipsArrayList = new ArrayList<Tips>();

    public ArrayList<Tips> getTipsArrayList() {
        return tipsArrayList;
    }

    public void setTipsArrayList(ArrayList<Tips> tipsArrayList) {
        this.tipsArrayList = tipsArrayList;
    }

    @Override
    public int getCode() {
        return super.getCode();
    }

    @Override
    public void setCode(int code) {
        super.setCode(code);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void setMessage(String message) {
        super.setMessage(message);
    }

}
