package com.testing1.example.android.testingpj.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.testing1.example.android.testingpj.Adapters.HistoryAdapter;
import com.testing1.example.android.testingpj.Items.HistoryItems;
import com.testing1.example.android.testingpj.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {


    private RecyclerView hRecylcer;
    private RecyclerView.Adapter hAdapter;
    private RecyclerView.LayoutManager hLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

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

        hRecylcer = (RecyclerView) findViewById(R.id.recycler_view_history);

        hRecylcer.setHasFixedSize(true);

        hLayoutManager = new LinearLayoutManager(this);

        hRecylcer.setLayoutManager(hLayoutManager);

        hAdapter = new HistoryAdapter(getApplicationContext(),getData());
        hRecylcer.setAdapter(hAdapter);
        hRecylcer.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    public List<HistoryItems> getData() {
        List<HistoryItems> data = new ArrayList<>();
        int[] imgHIstoryIDs = {R.drawable.thegreatshwedagon,R.drawable.historyofshwedagonpagoda,R.drawable.theoriginalshwedagon,R.drawable.thecolonialistday,R.drawable.raisingtheshwedagonpagoda};
        String[] arrayData = getResources().getStringArray(R.array.History);
        String[] historyDesc = {getResources().getString(R.string.theGreatShweDagon), getResources().getString(R.string.historyofshwedagonpagoda),
                getResources().getString(R.string.theoriginalshwedagon), getResources().getString(R.string.thecolonialistday), getResources().getString(R.string.raisingtheshwedagonpagoda)};
        for (int i = 0; i < arrayData.length && i < historyDesc.length; i++) {
            HistoryItems currentData = new HistoryItems(getApplicationContext());
            currentData.setTitle(arrayData[i]);
            currentData.setDesc(historyDesc[i]);
            currentData.setImageID(imgHIstoryIDs[i]);
            data.add(currentData);
        }
        return data;
    }

}
