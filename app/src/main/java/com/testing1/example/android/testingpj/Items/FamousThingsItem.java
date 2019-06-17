package com.testing1.example.android.testingpj.Items;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.testing1.example.android.testingpj.R;

/**
 * Created by Lenovo on 3/12/2016.
 */
public class FamousThingsItem extends CardView{

    public String itemName;
    TextView tvFamousItem;

    public FamousThingsItem(Context context) {
        super(context);
    }

    public FamousThingsItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FamousThingsItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvFamousItem = (TextView) findViewById(R.id.tv_famous_item);

    }

    public void setItemName(String desc) {
        tvFamousItem.setText(desc);
    }
}
