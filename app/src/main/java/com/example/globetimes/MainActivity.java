package com.example.globetimes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    TabItem xhome, xsports, xtech, xentertainment, xhealth, xscience;
    Toolbar xtoolbar;
    PagerAdapter pagerAdapter;

//    private SwipeRefreshLayout swipeRefreshLayout;

    String api = "a40e59e4d41c49b899e696f0c8c98739";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(xtoolbar);

        xhome = findViewById(R.id.home);
        xsports = findViewById(R.id.sports);
        xtech = findViewById(R.id.technology);
        xentertainment = findViewById(R.id.entertainment);
        xhealth = findViewById(R.id.health);
        xscience = findViewById(R.id.science);

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.tabLayout);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);




//        swipeRefreshLayout = findViewById(R.id.refreshlayout);
//        swipeRefreshLayout.setOnRefreshListener(this);



//        To get both direct clicking on items and swaping

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
       viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

//    @Override
//    public void onRefresh() {
//
//
//    }
}
