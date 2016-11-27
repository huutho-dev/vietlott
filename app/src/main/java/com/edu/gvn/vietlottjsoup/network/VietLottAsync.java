package com.edu.gvn.vietlottjsoup.network;

import android.os.AsyncTask;

import com.edu.gvn.vietlottjsoup.model.Max4d;
import com.edu.gvn.vietlottjsoup.model.Mega645;
import com.edu.gvn.vietlottjsoup.model.VietLott;
import com.edu.gvn.vietlottjsoup.model.sub.M4dModel;
import com.edu.gvn.vietlottjsoup.model.sub.M645Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by hnc on 25/11/2016.
 */

public class VietLottAsync extends AsyncTask<String, Void, VietLott> {

    public interface  OnLoadDataSuccess {
        void success(VietLott vietLott);
    }
    private OnLoadDataSuccess loadDataSuccess ;

    public VietLottAsync(OnLoadDataSuccess success){
        this.loadDataSuccess = success ;
    }

    @Override
    protected VietLott doInBackground(String... strings) {
        try {
            String url = strings[0];
            Document document = Jsoup.connect(url).get();

//========================================= Mega 6-45 tab ===============================================
            Elements mega645 = document.select("div.tab-content > div#mega-6-45");


            String title, deltail, luckyNumber, totalAward;
            ArrayList<M645Model> prizes = new ArrayList<>();

            title = mega645.select("div.lotto-result > h4").first().text();
            Elements resultGame = mega645.select("div.lotto-result > div#result-games");

            Element boxResultDetail = resultGame.select("div.box-result-detail").get(0); // size =  1
            String timeResult1 = boxResultDetail.select("p").get(0).text();
            String timeResult2 = boxResultDetail.select("p").get(1).text();
            String timeResult3 = boxResultDetail.select("p").get(2).text();
            deltail = timeResult1 + "\n" + timeResult2 + "\n" + timeResult3;


            String lucky = "";
            Element resultNumber = boxResultDetail.select("ul.result-number").get(0);
            Elements number = resultNumber.select("li");
            int numberSize = number.size();
            for (int i = 0; i < numberSize; i++) {
                lucky += number.get(i).text().trim();
            }
            luckyNumber = lucky;

            Element resultTable = resultGame.select("div.result.clearfix.table-responsive").get(0);
            Element tableStriped1 = resultTable.select("table.table.table-striped").get(0);
            String valueText = tableStriped1.select("thead > tr > th").text();
            String valueNumber = tableStriped1.select("tbody > tr > td ").text();
            totalAward = valueText + " : " + valueNumber;

            Element tableStriped2 = resultTable.select("table.table.table-striped").get(1);
//            Elements titleColumn = tableStriped2.select("thead  > tr > th");
//            String colum0 = titleColumn.get(0).text();
//            String colum1 = titleColumn.get(1).text();
//            String colum2 = titleColumn.get(2).text();
//            String colum3 = titleColumn.get(3).text();

            Elements valueRow = tableStriped2.select("tbody > tr");
            int sizeRow = valueRow.size();
            for (int i = 0; i < sizeRow; i++) {
                Element row = valueRow.get(i);
                Elements td = row.select("td");
                String awardName = td.get(0).text();
                String match = td.get(1).select("i").size() + "";
                String prizeAmount = td.get(2).text();
                String valuePrize = td.get(3).text();

                M645Model m645 = new M645Model(awardName, match, prizeAmount, valuePrize);
                prizes.add(m645);
            }

            Mega645 mega = new Mega645(title, deltail, luckyNumber, totalAward, prizes);


//======================================Mega max4d tab ===============================================
            Elements max4d = document.select("div.tab-content > div#max-4d");
            String title_max4, detail_max4;
            ArrayList<M4dModel> m4ds = new ArrayList<>();

            title_max4 = max4d.select("div.lotto-result > h4").first().text();
            Elements resultGame_max4 = max4d.select("div.lotto-result > div#result-games-max4d");
            Element boxResultDetail_max4 = resultGame_max4.select("div.box-result-detail").get(0); // size =  1
            String timeResult1_max4 = boxResultDetail_max4.select("p").get(0).text();
            String timeResult2_max4 = boxResultDetail_max4.select("p").get(1).text();
            detail_max4 = timeResult1_max4 + "\n" + timeResult2_max4;

            Element tableStriped_max4 = resultGame_max4.select("table.table.table-striped").get(0);
            Elements titleColumn_max4 = tableStriped_max4.select("thead  > tr > th");
            String colum0_max4 = titleColumn_max4.get(0).text();
            String colum1_max4 = titleColumn_max4.get(1).text();
            String colum2_max4 = titleColumn_max4.get(2).text();
            String colum3_max4 = titleColumn_max4.get(3).text();

            Elements valueRow_max4 = tableStriped_max4.select("tbody > tr");
            int sizeRow_max4 = valueRow.size();
            for (int i = 0; i < sizeRow_max4; i++) {
                Element row = valueRow_max4.get(i);
                Elements td = row.select("td");
                String awardName = td.get(0).text();
                String result = "";
                Elements eResult = td.get(1).getElementsByTag("b");
                for (int k = 0; k < eResult.size(); k++) {
                    result += eResult.get(k).text();
                }
                String prizeAmount = td.get(2).getElementsByTag("b").text();
                String valueAmount = td.get(3).getElementsByTag("b").text();

                M4dModel m4d = new M4dModel(awardName, result, prizeAmount, valueAmount);
                m4ds.add(m4d);
            }

            Max4d max = new Max4d(title_max4,detail_max4,m4ds);

//================================================================================================

            VietLott vietLott = new VietLott(mega,max);
            return vietLott;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(VietLott vietLott) {
        super.onPostExecute(vietLott);
        loadDataSuccess.success(vietLott);
    }
}
