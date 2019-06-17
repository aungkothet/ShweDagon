package com.testing1.example.android.testingpj.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.testing1.example.android.testingpj.Adapters.MyAdapter;
import com.testing1.example.android.testingpj.Items.ArtsAndArchiItem;
import com.testing1.example.android.testingpj.R;

import java.util.ArrayList;
import java.util.List;

public class ArtsAndArchiActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_and_archi);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new MyAdapter(getApplicationContext(),getData());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

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
    public List<ArtsAndArchiItem>  getData()
    {
        List<ArtsAndArchiItem> data = new ArrayList<>();
        String[] myDataset =  getApplication().getResources().getStringArray(R.array.ArchitectureAndArts);
        for(int i=0;i<myDataset.length;i++)
        {
            ArtsAndArchiItem current = new ArtsAndArchiItem(getApplicationContext());
            current.title = myDataset[i];
            data.add(current);
        }
        return  data;

    }
}
