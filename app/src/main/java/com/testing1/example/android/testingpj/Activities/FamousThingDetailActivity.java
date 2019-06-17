package com.testing1.example.android.testingpj.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.testing1.example.android.testingpj.R;

public class FamousThingDetailActivity extends AppCompatActivity {

    int index = 0;
    String clickedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_thing_detail);
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

        Intent intent = getIntent();

        //get extra text from intent to check the arts
        String aryName = intent.getStringExtra("famous");

        //var: for img view and text view
        ImageView imgFamous = (ImageView) findViewById(R.id.img_famous_detail);
        TextView tvFamous = (TextView) findViewById(R.id.tv_famous_detail);

        //to check where the extra Text is
        String[] Pagoda = getApplication().getResources().getStringArray(R.array.famour_thing_pagodas);
        String[] Statue = getApplication().getResources().getStringArray(R.array.famour_thing_statue);
        String[] Others = getApplication().getResources().getStringArray(R.array.famour_thing_others);
        //for description about clicked item ..
        String[] famousPagoda = getApplication().getResources().getStringArray(R.array.famous_thing_pagoda_desc);
        String[] famousStatue = getApplication().getResources().getStringArray(R.array.famous_thing_statue_desc);
        String[] famousOthers = getApplication().getResources().getStringArray(R.array.famous_thing_others_desc);
        //for image of the clicked item.....
        int[] imgStatue = {R.drawable.arahat, R.drawable.bomingaungstatue, R.drawable.botawsakkaandshwedagonbobogyi, R.drawable.dragonnagargalon, R.drawable.indrasakkameilamukingokkalapa, R.drawable.lawkaparlayakhaogressmaltawkyi, R.drawable.manokthiha, R.drawable.shinupagotetaarhat, R.drawable.shinizzagawnamonk, R.drawable.themalebrahmawithababyboy, R.drawable.twoogres, R.drawable.wasondari, R.drawable.yangonbobogyee, R.drawable.zawgyiandascetics};
        int[] imgPagoda = {R.drawable.chantharkyipagoda,R.drawable.nagatheingipagoda,R.drawable.padaukwinepagodas,R.drawable.pyitawpyanpagoda,R.drawable.razamunipagoda,R.drawable.sunandmoonpagoda,R.drawable.thebuddhaimageneartuesdaycorner,R.drawable.thejadebuddhaimage,R.drawable.thesolidgoldreplicaofshwedagonpagoda,R.drawable.tigerandlionpagoda };
        int[] imgOther = {R.drawable.aninscribedstonemonument,R.drawable.buddhasfootprint,R.drawable.buddhaslifthistoryexhibition,R.drawable.dahammacetiinscribedstones,R.drawable.gongs,R.drawable.gyotaing,R.drawable.kingtharawaddysbell,R.drawable.mahabodhibanyantree,R.drawable.replicacetiofrenovatedkingmindonshtitaw,R.drawable.shrineswithsmallglidedceti,R.drawable.shwedagonpagodaphotogallery,R.drawable.singuminsmahagandagreatbell,R.drawable.tagundaing,R.drawable.theoldremnantsofoldbritishfort,R.drawable.thesenguttarapark,R.drawable.thwaysaykanbloodcleaninglake,R.drawable.twopiecetazaung,R.drawable.whitewashedconcretereplicasofhtitaw};
        //for looping to pick the index
        for (int i = 0; i < Pagoda.length; i++) {
            if (Pagoda[i].equalsIgnoreCase(aryName)) {
                clickedItem = "famousPagoda";
                index = i;
            }
        }
        for (int i = 0; i < Statue.length; i++) {
            if (Statue[i].equalsIgnoreCase(aryName)) {
                clickedItem = "famousStatue";
                index = i;
            }
        }
        for (int i = 0; i < Others.length; i++) {
            if (Others[i].equalsIgnoreCase(aryName)) {
                clickedItem = "famousOther";
                index = i;
            }
        }
//insert data to appropirate views
        if (clickedItem.equalsIgnoreCase("famousPagoda")) {
            getSupportActionBar().setTitle(Pagoda[index]);
            imgFamous.setImageResource(imgPagoda[index]);
            tvFamous.setText(famousPagoda[index]);

        } else if (clickedItem.equalsIgnoreCase("famousStatue")) {
            getSupportActionBar().setTitle(Statue[index]);
            imgFamous.setImageResource(imgStatue[index]);
            tvFamous.setText(famousStatue[index]);

        } else if (clickedItem.equalsIgnoreCase("famousOther")) {
            getSupportActionBar().setTitle(Others[index]);
            imgFamous.setImageResource(imgOther[index]);
            tvFamous.setText(famousOthers[index]);
        }
    }
}
