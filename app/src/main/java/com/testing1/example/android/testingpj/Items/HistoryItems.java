package com.testing1.example.android.testingpj.Items;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.testing1.example.android.testingpj.R;

/**
 * Created by Lenovo on 3/9/2016.
 */
public class HistoryItems extends CardView {

    /* variables for history layout*/

    public TextView tvHistory;
    public  TextView tvHistoryTitle;
    public ImageView imgHistory;
    public HistoryItems(Context context) {
        super(context);
    }

    public HistoryItems(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HistoryItems(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override

    protected void onFinishInflate() {
        super.onFinishInflate();
        tvHistoryTitle = (TextView)findViewById(R.id.tv_history_title);
        tvHistory = (TextView)findViewById(R.id.tv_history_desc);
        imgHistory = (ImageView)findViewById(R.id.img_history);
    }
    private String desc;
    private int ImageID;
    private String title;


    public void setImageID(int ImageID) {
        this.ImageID = ImageID;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getImageID() {
        return this.ImageID;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getTitle() {
        return this.title;
    }


}
