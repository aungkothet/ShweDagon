package com.testing1.example.android.testingpj.Activities;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.testing1.example.android.testingpj.Fragments.EightFragment;
import com.testing1.example.android.testingpj.Fragments.FiveFragment;
import com.testing1.example.android.testingpj.Fragments.FourFragment;
import com.testing1.example.android.testingpj.Fragments.NineFragment;
import com.testing1.example.android.testingpj.Fragments.OneFragment;
import com.testing1.example.android.testingpj.Fragments.SevenFragment;
import com.testing1.example.android.testingpj.Fragments.SixFragment;
import com.testing1.example.android.testingpj.Fragments.ThreeFragment;
import com.testing1.example.android.testingpj.Fragments.TwoFragment;
import com.testing1.example.android.testingpj.R;

import java.util.ArrayList;
import java.util.List;

public class NineMiraclesActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_nine_miracles);
//
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //make status bar color
        int id = getResources().getIdentifier("config_enableTranslucentDecor",
                "bool", "android");
        if (id != 0 && getResources().getBoolean(id)) { // Translucent available
            Window w = getWindow();

            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, // Transparent
                    // Status
                    // Bar
                    // for
                    // Kit
                    // Kat
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); // Transparent
            // Status
            // Bar
            // for
            // Kit
            // Kat
        }

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        // enable status bar tint
        tintManager.setStatusBarTintEnabled(true);
        // enable navigation bar tint
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setStatusBarTintColor(Color.parseColor("#FF3140A0"));
        SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();
        findViewById(android.R.id.content).setPadding(0,
                config.getPixelInsetTop(true), config.getPixelInsetRight(),
                config.getPixelInsetBottom());


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "Padamya Myat Shin");
        adapter.addFrag(new TwoFragment(), "WeitZarZawGyi");
        adapter.addFrag(new ThreeFragment(), "Shin Saw Pu");
        adapter.addFrag(new FourFragment(), "San Taw Twin");
        adapter.addFrag(new FiveFragment(), "Shin Izza Gawna");
        adapter.addFrag(new SixFragment(), "BoBoAung Cave");
        adapter.addFrag(new SevenFragment(), "Shin Ma Htee");
        adapter.addFrag(new EightFragment(), "East LatPaLat");
        adapter.addFrag(new NineFragment(), "PyaDaShin");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
