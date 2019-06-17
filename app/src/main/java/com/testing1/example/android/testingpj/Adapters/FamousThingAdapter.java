package com.testing1.example.android.testingpj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.testing1.example.android.testingpj.Activities.FamousThingDetailActivity;
import com.testing1.example.android.testingpj.Items.FamousThingsItem;
import com.testing1.example.android.testingpj.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Lenovo on 3/12/2016.
 */
public class FamousThingAdapter extends RecyclerView.Adapter<FamousThingAdapter.MyViewHolder> {

    private LayoutInflater inflater;

    List<FamousThingsItem> data = Collections.emptyList();

    public FamousThingAdapter(Context context, List<FamousThingsItem> data) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.famous_things_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        FamousThingsItem current = data.get(position);

        holder.setItemText(current.itemName);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        String itemText;
        TextView tv_famous_desc;
        private final Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_famous_desc = (TextView) itemView.findViewById(R.id.tv_famous_item);

            context = itemView.getContext();
        }

        public void setItemText(String desc) {
            itemText = desc;
            tv_famous_desc.setText(itemText);
        }

        @Override
        public void onClick(View v) {

           final Intent intent=new Intent(context,FamousThingDetailActivity.class);
            intent.putExtra("famous",itemText);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
