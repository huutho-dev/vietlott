package com.edu.gvn.vietlottjsoup.model.sub;

/**
 * Created by hnc on 25/11/2016.
 */

public class M645Model {
    public String awardName;
    public String match;
    public String prizeAmount;
    public String value;

    public M645Model(String awardName, String match, String prizeAmount, String value) {
        this.awardName = awardName;
        this.match = match;
        this.prizeAmount = prizeAmount;
        this.value = value;
    }

    @Override
    public String toString() {
        return "M645Model{" +
                "awardName='" + awardName + '\'' +
                ", match='" + match + '\'' +
                ", prizeAmount='" + prizeAmount + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
