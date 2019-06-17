package com.testing1.example.android.testingpj.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.testing1.example.android.testingpj.R;

public class HistoryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
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

        //get index for which one is selected
        String title = getIntent().getStringExtra("title");

        ImageView img_historyDetail = (ImageView) findViewById(R.id.img_history_detail);
        TextView tv_historyDetail = (TextView) findViewById(R.id.tv_history_detail);
        int[] imgHIstoryIDs = {R.drawable.thegreatshwedagon,R.drawable.historyofshwedagonpagoda,R.drawable.theoriginalshwedagon,R.drawable.thecolonialistday,R.drawable.raisingtheshwedagonpagoda};
        String[] arrayData = getResources().getStringArray(R.array.History);
        String[] historyDesc = {getResources().getString(R.string.theGreatShweDagon), getResources().getString(R.string.historyofshwedagonpagoda),
                getResources().getString(R.string.theoriginalshwedagon), getResources().getString(R.string.thecolonialistday), getResources().getString(R.string.raisingtheshwedagonpagoda)};


        for (int index = 0; index < arrayData.length && index < historyDesc.length; index++)
        {
            if (arrayData[index].equalsIgnoreCase(title)) {
                tv_historyDetail.setText(historyDesc[index]);
                img_historyDetail.setImageResource(imgHIstoryIDs[index]);
                getSupportActionBar().setTitle(arrayData[index]);
            }
        }


    }
}
