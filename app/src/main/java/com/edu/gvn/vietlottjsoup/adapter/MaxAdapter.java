package com.edu.gvn.vietlottjsoup.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.edu.gvn.vietlottjsoup.R;
import com.edu.gvn.vietlottjsoup.model.sub.M4dModel;

import java.util.List;

/**
 * Created by hnc on 25/11/2016.
 */

public class MaxAdapter extends ArrayAdapter<M4dModel> {
    private Context context;
    private List<M4dModel> objects;
    private LayoutInflater inflater;

    public MaxAdapter(Context context, int resource, List<M4dModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_max, parent, false);
        TextView name, result, amount, values;
        name = (TextView) convertView.findViewById(R.id.name);
        result = (TextView) convertView.findViewById(R.id.result);
        amount = (TextView) convertView.findViewById(R.id.amount);
        values = (TextView) convertView.findViewById(R.id.values);

        name.setText(objects.get(position).awardName);

        String myResult = objects.get(position).result;
        result.setText(getResult(myResult));

        amount.setText(objects.get(position).prizeAmount);
        values.setText(objects.get(position).value);
        return convertView;
    }

    public String getResult(String parent) {
        int lenght = parent.length();
        String result = "";
        if (lenght == 4) {
            return parent;
        }
        if (lenght == 8) {
            String str1 = parent.substring(0, 4);
            String str2 = parent.substring(4, lenght);
            result = str1 + " - " + str2;
            return result;
        }
        if (lenght == 12) {
            String str1 = parent.substring(0, 4);
            String str2 = parent.substring(4, 8);
            String str3 = parent.substring(8, lenght);
            result = str1 + " - " + str2 + " - " + str3;
            return result;
        }
        return null;
    }
}
