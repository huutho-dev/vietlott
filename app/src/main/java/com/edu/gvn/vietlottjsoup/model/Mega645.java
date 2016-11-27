package com.edu.gvn.vietlottjsoup.model;

import com.edu.gvn.vietlottjsoup.model.sub.M645Model;

import java.util.List;

/**
 * Created by hnc on 25/11/2016.
 */

public class Mega645 {
    public String title;
    public String detail;
    public String luckyNumber;
    public String totalAward;
    public List<M645Model> prizes;

    public Mega645(String title, String detail, String luckyNumber, String totalAward, List<M645Model> prizes) {
        this.title = title;
        this.detail = detail;
        this.luckyNumber = luckyNumber;
        this.totalAward = totalAward;
        this.prizes = prizes;
    }

    @Override
    public String toString() {
        return "Mega645{" +
                "title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", luckyNumber='" + luckyNumber + '\'' +
                ", totalAward='" + totalAward + '\'' +
                ", prizes=" + prizes +
                '}';
    }

}
