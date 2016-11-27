package com.edu.gvn.vietlottjsoup.model;

/**
 * Created by hnc on 25/11/2016.
 */

public class VietLott {
    public Mega645 mega645;
    public Max4d m4dModel;

    public VietLott(Mega645 mega645, Max4d m4dModel) {
        this.mega645 = mega645;
        this.m4dModel = m4dModel;
    }

    @Override
    public String toString() {
        return "VietLott{" +
                "mega645=" + mega645 +
                ", m4dModel=" + m4dModel +
                '}';
    }
}
