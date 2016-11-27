package com.edu.gvn.vietlottjsoup.model.sub;

/**
 * Created by hnc on 25/11/2016.
 */

public class M4dModel {
    public String awardName;
    public String result;
    public String prizeAmount;
    public String value;

    public M4dModel(String awardName, String result, String prizeAmount, String value) {
        this.awardName = awardName;
        this.result = result;
        this.prizeAmount = prizeAmount;
        this.value = value;
    }

    @Override
    public String toString() {
        return "M4dModel{" +
                "awardName='" + awardName + '\'' +
                ", result='" + result + '\'' +
                ", prizeAmount='" + prizeAmount + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
