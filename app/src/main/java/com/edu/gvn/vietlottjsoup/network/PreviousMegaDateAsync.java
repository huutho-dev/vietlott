package com.edu.gvn.vietlottjsoup.network;

import android.os.AsyncTask;

import com.edu.gvn.vietlottjsoup.model.MegaDatePrevious;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HuuTho on 11/27/2016.
 */

public class PreviousMegaDateAsync extends AsyncTask<String, Void, ArrayList<MegaDatePrevious>> {

    public interface PreviousMegaDateAsyncCallback {
        void callback(ArrayList<MegaDatePrevious> data);
    }

    private PreviousMegaDateAsyncCallback callback ;

    public PreviousMegaDateAsync(PreviousMegaDateAsyncCallback callback){
        this.callback = callback;
    }

    @Override
    protected ArrayList<MegaDatePrevious> doInBackground(String... params) {
        String url = params[0];
        ArrayList<MegaDatePrevious> data = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).get();
            Elements tr = document.select
                    ("div.col-xs-12.col-md-10.news-page > div.result.clearfix.table-responsive > table.table.table-striped > tbody > tr");
            int sizeTr = tr.size();
            for (int i = 0; i < sizeTr; i++) {
                String date = tr.get(i).select("td").get(0).select("a").text();
                String link = tr.get(i).select("td").get(0).select("a").attr("href");
                String result = tr.get(i).select("td").get(1).text();

                MegaDatePrevious megaDatePrevious = new MegaDatePrevious(date, link, result);
                data.add(megaDatePrevious);
            }
            return data;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<MegaDatePrevious> megaDatePreviouses) {
        super.onPostExecute(megaDatePreviouses);

        callback.callback(megaDatePreviouses);
    }
}
