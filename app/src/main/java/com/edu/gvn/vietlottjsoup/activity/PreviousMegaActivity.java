package com.edu.gvn.vietlottjsoup.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.edu.gvn.vietlottjsoup.R;
import com.edu.gvn.vietlottjsoup.model.MegaDatePrevious;
import com.edu.gvn.vietlottjsoup.network.PreviousMegaDateAsync;

import java.util.ArrayList;

/**
 * Created by HuuTho on 11/27/2016.
 */

public class PreviousMegaActivity extends AppCompatActivity {
    private ListView listdate;
    private ArrayList<MegaDatePrevious> megaDatePreviouses;
    private PreviousMegaAdapter adapter ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_mega);
        listdate = (ListView) findViewById(R.id.listdate);

        megaDatePreviouses = new ArrayList<>();
        adapter = new PreviousMegaAdapter(this,android.R.layout.simple_list_item_1,megaDatePreviouses);
        listdate.setAdapter(adapter);
        listdate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        PreviousMegaDateAsync previousMegaDateAsync = new PreviousMegaDateAsync(new PreviousMegaDateAsync.PreviousMegaDateAsyncCallback() {
            @Override
            public void callback(ArrayList<MegaDatePrevious> data) {
                megaDatePreviouses.clear();
                megaDatePreviouses.addAll(data);
                adapter.notifyDataSetChanged();
            }
        });

        previousMegaDateAsync.execute("http://vietlott.vn/vi/trung-thuong/ket-qua-trung-thuong/mega-6-45/winning-numbers/?p=1");
    }

    private class PreviousMegaAdapter extends ArrayAdapter<MegaDatePrevious> {
        private Context context ;
        private ArrayList<MegaDatePrevious> objs ;
        private LayoutInflater inflater ;

        public PreviousMegaAdapter(Context context, int resource, ArrayList<MegaDatePrevious> objects) {
            super(context, resource, objects);
            this.context = context ;
            this.objs = objects;
            inflater = LayoutInflater.from(context);

        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.item_previous_date,parent,false);
            TextView textView7 = (TextView) convertView.findViewById(R.id.textView7);
            TextView textView8 = (TextView) convertView.findViewById(R.id.textView8);
            textView7.setText(objs.get(position).date);
            textView8.setText(objs.get(position).result);
            return convertView ;
        }
    }
}
