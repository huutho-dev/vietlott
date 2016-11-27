package com.edu.gvn.vietlottjsoup.network;

import android.os.AsyncTask;
import android.util.Log;

import com.edu.gvn.vietlottjsoup.model.ResultMax4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by HuuTho on 11/27/2016.
 */

public class PreviousMaxAsync extends AsyncTask<String, Void, List<ResultMax4>> {
    public interface PreviousMaxCallBack {
        void callBack(List<ResultMax4> data);
    }

    private PreviousMaxCallBack callBack;

    public PreviousMaxAsync(PreviousMaxCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    protected List<ResultMax4> doInBackground(String... params) {

        List<ResultMax4> listData = new ArrayList<>();

        try {
            String url = params[0];
            Document document = Jsoup.connect(url).get();
            Elements table = document.select("table.table.table-striped > tbody >tr");
            int tableSize = table.size();
            for (int i = 0; i < tableSize; i++) {

                Elements td = table.get(i).select("td");

                String image = td.get(0).select("img").attr("src");
                String time = td.get(1).select("div.info-result-game > span").text();
                Elements lis = td.get(2).select("ul.result-max4d > li");

                Log.e(TAG, "doInBackground: " + lis.size());

                String giaiNhat = lis.get(0).select("div.box-result-max4d").get(0).text();

                String giaiNhi = lis.get(0).select("div.box-result-max4d").get(1).text();

                String giaiBa = lis.get(1).select("div.box-result-max4d").text();

                String khuyenKhich1 = lis.get(2).select("div.box-result-max4d").get(0).text();
                String khuyenKhich2 = lis.get(2).select("div.box-result-max4d").get(1).text();


                Log.v("huutho", image + "\n" + time + "\n" + giaiNhat + "\n" + giaiNhi + "\n" + giaiBa + "\n" + khuyenKhich1 + "\n" + khuyenKhich2);

                ResultMax4 resultMax4 = new ResultMax4(time, giaiNhat, giaiNhi, giaiBa, khuyenKhich1, khuyenKhich2);
                listData.add(resultMax4);
            }

            return listData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<ResultMax4> resultMax4s) {
        super.onPostExecute(resultMax4s);
        callBack.callBack(resultMax4s);
    }
}
