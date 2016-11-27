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
import com.edu.gvn.vietlottjsoup.activity.PreviousMegaActivity;
import com.edu.gvn.vietlottjsoup.adapter.MegaAdapter;
import com.edu.gvn.vietlottjsoup.model.Mega645;

/**
 * Created by hnc on 25/11/2016.
 */

public class MegaFragment extends Fragment implements View.OnClickListener {
    private TextView title, detail, lucky;
    private ListView listMega;
    private MegaAdapter megaAdapter;
    private Mega645 mega645;

    private Button btn ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mega, container, false);
        title = (TextView) view.findViewById(R.id.title);
        detail = (TextView) view.findViewById(R.id.detail);
        lucky = (TextView) view.findViewById(R.id.luckynumber);
        listMega = (ListView) view.findViewById(R.id.list_mega);

        btn = (Button) view.findViewById(R.id.btn_previous);

        btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void updateView(Mega645 mega) {
        this.mega645 = mega;
        megaAdapter = new MegaAdapter(getContext(), android.R.layout.simple_list_item_1, mega645.prizes);
        title.setText(mega645.title);
        detail.setText(mega645.detail);
        lucky.setText(mega645.luckyNumber);
        listMega.setAdapter(megaAdapter);
        megaAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        getActivity().startActivity(new Intent(getActivity(), PreviousMegaActivity.class));
    }
}
