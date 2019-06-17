package com.testing1.example.android.testingpj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.testing1.example.android.testingpj.Activities.ArtsAndArchiDetailActivity;
import com.testing1.example.android.testingpj.Items.ArtsAndArchiItem;
import com.testing1.example.android.testingpj.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Lenovo on 3/9/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private LayoutInflater inflater;

    List<ArtsAndArchiItem> data = Collections.emptyList();

    public MyAdapter(Context context, List<ArtsAndArchiItem> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.arts_and_archi_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ArtsAndArchiItem current = data.get(position);

        holder.setItemText(current.title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        String itemText;
        TextView tv_arts_desc;
        private final Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_arts_desc = (TextView) itemView.findViewById(R.id.tv_arts_item);

            context=itemView.getContext();
        }

        public void setItemText(String desc) {
            itemText = desc;
            tv_arts_desc.setText(itemText);
        }

        @Override
        public void onClick(View v) {

            final Intent intent=new Intent(context,ArtsAndArchiDetailActivity.class);
            intent.putExtra("arts",itemText);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }
}
