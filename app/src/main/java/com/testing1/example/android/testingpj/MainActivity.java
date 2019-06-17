package com.testing1.example.android.testingpj;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.testing1.example.android.testingpj.Activities.ArtsAndArchiActivity;
import com.testing1.example.android.testingpj.Activities.FamousThingActivity;
import com.testing1.example.android.testingpj.Activities.HistoryActivity;
import com.testing1.example.android.testingpj.Activities.NineMiraclesActivity;
import com.testing1.example.android.testingpj.Activities.SeasonalFestivalActivity;

public class
MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=Shwedagon Pagoda"));
                startActivity(intent);
            }
        });

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

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /* Methods for buttons Click */
    public void historyClick(View view) {
        startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
    }

    public void artsAndArchiClick(View view) {
        startActivity(new Intent(getApplicationContext(), ArtsAndArchiActivity.class));
    }

    public void nineMiraclesClick(View view) {
        startActivity(new Intent(getApplicationContext(), NineMiraclesActivity.class));
    }

    public void seasonalFestivalClick(View view) {
        startActivity(new Intent(getApplicationContext(), SeasonalFestivalActivity.class));
    }

    public void famousThingClick(View view) {
        startActivity(new Intent(getApplicationContext(), FamousThingActivity.class));
    }

    public void settingClick(View view) {
        Snackbar.make(view, "Setting Clicked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }
}
