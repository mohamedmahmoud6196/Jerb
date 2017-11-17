package com.example.m7mdmimo.jerb.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by m7md mimo on 11/10/2017.
 */

public class GuestTodResponse extends Response {

    @SerializedName("data")
    @Expose
    private ArrayList<GuestTodo> guestTodos = new ArrayList<>();

    public ArrayList<GuestTodo> getGuestTodos() {
        return guestTodos;
    }

    public void setGuestTodos(ArrayList<GuestTodo> guestTodos) {
        this.guestTodos = guestTodos;
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
