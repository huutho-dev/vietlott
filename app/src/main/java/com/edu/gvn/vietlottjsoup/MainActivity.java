package com.edu.gvn.vietlottjsoup;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.edu.gvn.vietlottjsoup.adapter.VietLottPagerAdapter;
import com.edu.gvn.vietlottjsoup.model.VietLott;
import com.edu.gvn.vietlottjsoup.network.VietLottAsync;

public class MainActivity extends AppCompatActivity implements VietLottAsync.OnLoadDataSuccess {
    private ViewPager pager;
    private TabLayout tab;
    private VietLottPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new VietLottPagerAdapter(getSupportFragmentManager());
        tab = (TabLayout) findViewById(R.id.tablayout);
        pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);


        VietLottAsync async = new VietLottAsync(this);
        async.execute("http://vietlott.vn/vi/home/");
    }

    @Override
    public void success(VietLott vietLott) {
        adapter.updateData(vietLott);
    }
}
