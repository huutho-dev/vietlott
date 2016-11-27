package com.edu.gvn.vietlottjsoup.model;

import com.edu.gvn.vietlottjsoup.model.sub.M4dModel;

import java.util.List;

/**
 * Created by hnc on 25/11/2016.
 */

public class Max4d {
    public String title;
    public String detail;
    public List<M4dModel> m4ds;

    public Max4d(String title, String detail, List<M4dModel> m4ds) {
        this.title = title;
        this.detail = detail;
        this.m4ds = m4ds;
    }

    @Override
    public String toString() {
        return "Max4d{" +
                "title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", m4ds=" + m4ds +
                '}';
    }
}
