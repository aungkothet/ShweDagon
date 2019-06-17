package com.testing1.example.android.testingpj.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.testing1.example.android.testingpj.R;

public class ArtsAndArchiDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_and_archi_detail);
        Intent intent = getIntent();

        //get extra text from intent to check the arts


        String arts = intent.getStringExtra("arts");
        getSupportActionBar().setTitle(arts);
        //var: for img view and text view
        ImageView imgArts = (ImageView) findViewById(R.id.img_arts_detail);
        TextView tvArts = (TextView) findViewById(R.id.tv_arts_detail);

        //for arts and archi: array to ckeck with extra text String

        String[] myDataset = getApplication().getResources().getStringArray(R.array.ArchitectureAndArts);
        String[] artsDetail = getApplication().getResources().getStringArray(R.array.detailArts);

        //for images resources
        int[] imgArtsDetail = {R.drawable.heightofshwedagonpagoda, R.drawable.designandsections, R.drawable.plinthupperterrace,
                R.drawable.terraces, R.drawable.bellshapeddome, R.drawable.phaungyit, R.drawable.kyanu, R.drawable.kyalan,
                R.drawable.kyahmout, R.drawable.ywelone, R.drawable.htidout, R.drawable.hngetpyawphu, R.drawable.htitaw,
                R.drawable.hngetmyatna, R.drawable.seinphutaw, R.drawable.tentraditionalartsandcrafts, R.drawable.kindsofbuddhastatues,
                R.drawable.classificationofmudrasofthebuddhastatues, R.drawable.interestingfeaturesaroundthepagodaplatform,
                R.drawable.tenjatakas, R.drawable.eightprincipalscenesinbuddhaslife, R.drawable.eightexternalvictoriesofgauttamabuddha};
        for (int i = 0; i < myDataset.length; i++) {
            if (arts.equalsIgnoreCase(myDataset[i])) {
                tvArts.setText(artsDetail[i]);
                imgArts.setImageResource(imgArtsDetail[i]);
            }
        }

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
}
