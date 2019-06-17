package com.testing1.example.android.testingpj.Items;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.testing1.example.android.testingpj.R;

import org.w3c.dom.Text;

/**
 * Created by Lenovo on 3/9/2016.
 */
public class ArtsAndArchiItem extends CardView {

    public String title;
    TextView tvArtsItem;

    public ArtsAndArchiItem(Context context) {
        super(context);
    }

    public ArtsAndArchiItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ArtsAndArchiItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvArtsItem = (TextView) findViewById(R.id.tv_arts_item);

    }

    public void setTitle(String desc) {
        tvArtsItem.setText(desc);
    }
}
