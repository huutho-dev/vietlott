package com.edu.gvn.vietlottjsoup.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.edu.gvn.vietlottjsoup.R;
import com.edu.gvn.vietlottjsoup.model.ResultMax4;
import com.edu.gvn.vietlottjsoup.network.PreviousMaxAsync;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuuTho on 11/27/2016.
 */

public class PreviousMaxActivity extends AppCompatActivity {

    private ListView listView ;
    private MaxPreviousAdapter adapter ;
    private ArrayList<ResultMax4> mData ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_max);
        mData = new ArrayList<>();
        adapter = new MaxPreviousAdapter(this,android.R.layout.simple_list_item_1,mData);
        listView = (ListView) findViewById(R.id.listmax);
        listView.setAdapter(adapter);

        PreviousMaxAsync previousMaxAsync = new PreviousMaxAsync(new PreviousMaxAsync.PreviousMaxCallBack() {
            @Override
            public void callBack(List<ResultMax4> data) {
                mData.clear();
                mData.addAll(data);
                adapter.notifyDataSetChanged();
            }
        });

        previousMaxAsync.execute("http://vietlott.vn/vi/trung-thuong/ket-qua-trung-thuong/max-4d/winning-numbers/");
    }


    private class MaxPreviousAdapter extends ArrayAdapter<ResultMax4> {
        private Context context;
        private ArrayList<ResultMax4> obj;
        private LayoutInflater inflater ;
        public MaxPreviousAdapter(Context context, int resource, ArrayList<ResultMax4> objects) {
            super(context, resource, objects);
            this.context = context;
            this.obj = objects;
            inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.item_previous_max,parent,false);
            TextView textView = (TextView) convertView.findViewById(R.id.textView);
            TextView textView2 = (TextView) convertView.findViewById(R.id.textView2);
            TextView textView3 = (TextView) convertView.findViewById(R.id.textView3);
            TextView textView4 = (TextView) convertView.findViewById(R.id.textView4);
            TextView textView5 = (TextView) convertView.findViewById(R.id.textView5);
            TextView textView6 = (TextView) convertView.findViewById(R.id.textView6);

            textView.setText(obj.get(position).date);
            textView2.setText(obj.get(position).giaiNhat);
            textView3.setText(obj.get(position).giaiNhi);
            textView4.setText(obj.get(position).giaiBa);
            textView5.setText(obj.get(position).giaiKhuyenKhich1);
            textView6.setText(obj.get(position).giaiKhuyenKhich2);

            return convertView ;
        }
    }
}
