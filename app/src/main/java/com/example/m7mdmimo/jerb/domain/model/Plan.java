package com.example.m7mdmimo.jerb.domain.model;

import io.realm.RealmObject;

/**
 * Created by m7md mimo on 11/12/2017.
 */

public class Plan extends RealmObject {
    private int guest_num, cost, statistics;
    private String name, location;

    public Plan() {

    }

    public Plan(int guest_num, int cost, String location) {
        this.guest_num = guest_num;
        this.cost = cost;
        this.location = location;
    }

    public Plan(int guest_num, int cost, int statistics, String name, String location) {
        this.guest_num = guest_num;
        this.cost = cost;
        this.statistics = statistics;
        this.name = name;
        this.location = location;
    }

    public int getGuest_num() {
        return guest_num;
    }

    public void setGuest_num(int guest_num) {
        this.guest_num = guest_num;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getStatistics() {
        return statistics;
    }

    public void setStatistics(int statistics) {
        this.statistics = statistics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
