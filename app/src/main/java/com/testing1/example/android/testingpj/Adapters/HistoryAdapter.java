package com.testing1.example.android.testingpj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.testing1.example.android.testingpj.Activities.HistoryDetailActivity;
import com.testing1.example.android.testingpj.Items.HistoryItems;
import com.testing1.example.android.testingpj.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Lenovo on 3/10/2016.
 */
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private LayoutInflater inflater;

    List<HistoryItems> items = Collections.emptyList();

    public HistoryAdapter(Context context, List<HistoryItems> items) {
        inflater = LayoutInflater.from(context);
        this.items = items;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.history_items, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HistoryItems current = items.get(position);

        holder.setHistory_title(current.getTitle());
        holder.setImg_history(current.getImageID());
        holder.setHistory_desc(current.getDesc());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final Context context;
        TextView history_title, history_desc;
        ImageView img_history;

        //to check which item is click
        String historyTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            context = itemView.getContext();
            history_desc = (TextView) itemView.findViewById(R.id.tv_history_desc);
            history_title = (TextView) itemView.findViewById(R.id.tv_history_title);
            img_history = (ImageView) itemView.findViewById(R.id.img_history);

        }


        public void setHistory_title(String title) {
            historyTitle = title;
            history_title.setText(historyTitle);

        }

        public void setHistory_desc(String desc) {
            history_desc.setText(desc);
        }

        public void setImg_history(int imgID) {
            img_history.setImageResource(imgID);
        }

        @Override
        public void onClick(View v) {
            final Intent intent = new Intent(context, HistoryDetailActivity.class);
            intent.putExtra("title", historyTitle);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
