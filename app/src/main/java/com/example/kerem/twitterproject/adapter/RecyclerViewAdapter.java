package com.example.kerem.twitterproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.kerem.twitterproject.R;
import com.example.kerem.twitterproject.model.Statuses;
import java.util.List;


public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Statuses> statuses;
    private Context context;


    public RecyclerViewAdapter(List<Statuses> statuses, Context context) {
        this.statuses = statuses;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tweetText.setText(statuses.get(i).getText());
        viewHolder.tweetUsername.setText(statuses.get(i).getUser().getName());
        viewHolder.screenUsername.setText(" @"+statuses.get(i).getUser().getScreenName());
        viewHolder.createdTime.setText(statuses.get(i).getDate());

        Glide.with(context).load(statuses.get(i).getUser().getBackgroundImage()).into(viewHolder.image);

    }

    @Override
    public int getItemCount() {
        return statuses.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tweetText,tweetUsername,screenUsername,createdTime;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            tweetText = itemView.findViewById(R.id.text);
            tweetUsername = itemView.findViewById(R.id.name);
            screenUsername = itemView.findViewById(R.id.screenName);
            createdTime = itemView.findViewById(R.id.createdTime);
            image = itemView.findViewById(R.id.profileImage);
        }
    }
}

