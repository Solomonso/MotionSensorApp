package com.example.motionsensorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ReportActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewPagerAdaptor adaptor;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setTitle("Reports");
        viewPager = findViewById(R.id.pager);
        adaptor = new ViewPagerAdaptor(getSupportFragmentManager());
        viewPager.setAdapter(adaptor);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
