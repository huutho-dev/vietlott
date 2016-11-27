package com.edu.gvn.vietlottjsoup.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.edu.gvn.vietlottjsoup.R;
import com.edu.gvn.vietlottjsoup.activity.PreviousMaxActivity;
import com.edu.gvn.vietlottjsoup.adapter.MaxAdapter;
import com.edu.gvn.vietlottjsoup.model.Max4d;

/**
 * Created by hnc on 25/11/2016.
 */

public class MaxFragment extends Fragment implements View.OnClickListener {
    private TextView title, detail;
    private ListView listMax;
    private Max4d max4d;
    private MaxAdapter maxAdapter ;

    private Button btnPrevious ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_max, container, false);
        title = (TextView) view.findViewById(R.id.title);
        detail = (TextView) view.findViewById(R.id.detail);
        listMax = (ListView) view.findViewById(R.id.list_max);

        btnPrevious = (Button) view.findViewById(R.id.previous);
        btnPrevious.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void updateView(Max4d  max4d) {
        this.max4d = max4d;
        maxAdapter = new MaxAdapter(getContext(), android.R.layout.simple_list_item_1, max4d.m4ds);
        title.setText(max4d.title);
        detail.setText(max4d.detail);
        listMax.setAdapter(maxAdapter);
        maxAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        getActivity().startActivity(new Intent(getActivity(), PreviousMaxActivity.class));
    }
}
