package com.edu.gvn.vietlottjsoup.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.edu.gvn.vietlottjsoup.R;
import com.edu.gvn.vietlottjsoup.model.sub.M645Model;

import java.util.List;

/**
 * Created by hnc on 25/11/2016.
 */

public class MegaAdapter extends ArrayAdapter<M645Model> {
    private Context context;
    private List<M645Model> objects;
    private LayoutInflater inflater;

    public MegaAdapter(Context context, int resource,List<M645Model> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView name, match, amount, values;

            convertView = inflater.inflate(R.layout.item_mega, parent, false);
            name = (TextView) convertView.findViewById(R.id.name);
            match = (TextView) convertView.findViewById(R.id.match);
            amount = (TextView) convertView.findViewById(R.id.amount);
            values = (TextView) convertView.findViewById(R.id.values);

        name.setText(objects.get(position).awardName);
        match.setText(objects.get(position).match);
        amount.setText(objects.get(position).prizeAmount);
        values.setText(objects.get(position).value);
        return convertView;
    }
}
